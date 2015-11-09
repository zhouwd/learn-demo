package com.joe.learn.urlmap.dto;

import java.util.List;

public class RequestToMethodItem {
    private String controllerName;
    private String methodName;
    private String requestType;
    private String requestUrl;
    private String requestHost;
    private List<Class2Json> classJsonList;


	public RequestToMethodItem(String controllerName) {
		this.controllerName = controllerName;
	}

	public RequestToMethodItem(String requestUrl, String requestHost, String requestType, String controllerName, String requestMethodName,
                               List<Class2Json> classJsonList) {
        this.requestUrl = requestUrl;
        this.requestHost = requestHost;
        this.requestType = requestType;
        this.controllerName = controllerName;
        this.methodName = requestMethodName;
        this.classJsonList = classJsonList;

    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestHost() {
        return requestHost;
    }

    public void setRequestHost(String requestHost) {
        this.requestHost = requestHost;
    }

    public List<Class2Json> getClassJsonList() {
        return classJsonList;
    }

    public void setClassJsonList(List<Class2Json> classJsonList) {
        this.classJsonList = classJsonList;
    }

}