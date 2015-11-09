package com.joe.learn.urlmap.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.joe.learn.urlmap.dto.Class2Json;
import com.joe.learn.urlmap.dto.RequestToMethodItem;


@Controller
@RequestMapping("/spring-common")
public class MapController {

	private List<RequestToMethodItem> methodItemList=null;

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	@RequestMapping(value = "/indexController", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView queryControllerList(HttpServletRequest request) {
		List<RequestToMethodItem> itemList = getSingleMethodList(request);
		Map<String, List<RequestToMethodItem>> itemMap = new HashMap<String, List<RequestToMethodItem>>();
		for(RequestToMethodItem item:itemList) {
			List<RequestToMethodItem> tempList = itemMap.get(item.getControllerName());
			if (tempList == null) {
				tempList = new ArrayList<RequestToMethodItem>();
				itemMap.put(item.getControllerName(), tempList);
			}
			tempList.add(item);
		}
		List<Count> countList = new ArrayList<Count>();
		for(String key:itemMap.keySet()){
			Count count=new Count(key,itemMap.get(key).size());
			countList.add(count);
		}

		return new ModelAndView("index-controller").addObject("countList", countList).addObject("requestHost", getRootPath(request));
	}


	@RequestMapping(value = "/indexMethod", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView queryMethodList(HttpServletRequest request) {
		String controllerName=request.getParameter("controllerName");
		List<RequestToMethodItem> requestToMethodItemList = getSingleMethodList(request);
		List<RequestToMethodItem> resultItemList=new ArrayList<RequestToMethodItem>();
		for(RequestToMethodItem item:requestToMethodItemList){
			if(controllerName.equals(item.getControllerName())) {
				resultItemList.add(item);
			}
		}
		Collections.sort(resultItemList, new Comparator<RequestToMethodItem>() {
			@Override
			public int compare(RequestToMethodItem o1, RequestToMethodItem o2) {
				int i = o2.getControllerName().compareTo(o1.getControllerName());
				if (i != 0) {
					return i;
				}
				return o2.getMethodName().compareTo(o1.getMethodName());
			}
		});
		return new ModelAndView("index-method").addObject("methodList", resultItemList).addObject("controllerName", request.getParameter("controllerName")).addObject("methodSize", resultItemList.size()).addObject("requestHost", getRootPath(request));
	}


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView queryAllList(HttpServletRequest request) {
		List<RequestToMethodItem> requestToMethodItemList = getSingleMethodList(request);
		//添加排序，首先按照controller名称排序，如果一致，则按照方法名排序。降序排序。
		Collections.sort(requestToMethodItemList, new Comparator<RequestToMethodItem>() {
			@Override
			public int compare(RequestToMethodItem o1, RequestToMethodItem o2) {
				int i = o2.getControllerName().compareTo(o1.getControllerName());
				if (i != 0) {
					return i;
				}
				return o2.getMethodName().compareTo(o1.getMethodName());
			}
		});
		return new ModelAndView("index-all").addObject("methodList", requestToMethodItemList).addObject("requestHost", getRootPath(request));
	}


	private List<RequestToMethodItem> getSingleMethodList(HttpServletRequest request){
		if(methodItemList==null){
			methodItemList = new ArrayList<RequestToMethodItem>();
			ServletContext servletContext = request.getSession().getServletContext();
			if (servletContext == null) {
				return methodItemList;
			}
			WebApplicationContext appContext = RequestContextUtils.getWebApplicationContext(request, request.getSession().getServletContext());

			//请求url和处理方法的映射
			//获取所有的RequestMapping
			Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
			for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
				RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
				HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();

				RequestMethodsRequestCondition methodCondition = requestMappingInfo.getMethodsCondition();
				String requestType = "No method found.";
				if (methodCondition.getMethods().size() > 0) {
					requestType = methodCondition.getMethods().toString();
				}

				PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
				String requestUrl = "no pattern found.";
				if (patternsCondition.getPatterns().size() > 0) {
					requestUrl = patternsCondition.getPatterns().toArray()[0].toString();
				}

				String controllerName = mappingInfoValue.getBeanType().toString().substring(6);


				String requestMethodName = mappingInfoValue.getMethod().getName();
				Class<?>[] methodParamTypes = mappingInfoValue.getMethod().getParameterTypes();

				String requestHost = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + requestUrl;
				RequestToMethodItem item = new RequestToMethodItem(requestUrl, requestHost, requestType, controllerName, requestMethodName, class2Json(methodParamTypes));

				methodItemList.add(item);
			}
		}
		return methodItemList;
	}

	private List<Class2Json> class2Json(Class<?>[] methodParamTypes) {
		List<Class2Json> classJsonList = new ArrayList<Class2Json>();
		if (methodParamTypes == null || methodParamTypes.length == 0) {
			return classJsonList;
		}
		for (Class clazz : methodParamTypes) {
			String simpleName = clazz.getSimpleName();
			if (getSimpleClassType().indexOf(simpleName) < 0) {
				Field[] fields = clazz.getDeclaredFields();

				StringBuilder stringBuffer = new StringBuilder();
				for (Field field : fields) {
					String className = field.getType().getSimpleName();


					if (getSimpleClassType().contains(className)) {
						stringBuffer.append("\"").append(field.getName()).append("\":\"\",");
					}
				}
				simpleName = stringBuffer.toString();
				if(simpleName.length()>0){
					simpleName = simpleName.substring(0, simpleName.length() - 1);
				}
			}
			Class2Json classJson = new Class2Json(clazz.toString(), simpleName);
			classJsonList.add(classJson);
		}
		return classJsonList;
	}


	private String getRootPath(HttpServletRequest request){
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	}

	private List<String> getSimpleClassType() {
		List<String> simpleClassList = new ArrayList<String>();
		simpleClassList.add("String");
		simpleClassList.add("Integer");
		simpleClassList.add("Date");
		simpleClassList.add("Boolean");
		simpleClassList.add("int");
		simpleClassList.add("boolean");
		return simpleClassList;
	}

	static class Count{
		private String controllerName;
		private Integer size;

		public Count(String controllerName, int size) {
			this.controllerName=controllerName;
			this.size=size;
		}

		public String getControllerName() {
			return controllerName;
		}

		public void setControllerName(String controllerName) {
			this.controllerName = controllerName;
		}

		public Integer getSize() {
			return size;
		}

		public void setSize(Integer size) {
			this.size = size;
		}
	}
}

