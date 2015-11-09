package com.joe.spring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.joe.spring.dto.Employee;
import com.joe.spring.service.EmployeeService;

/**
 * 经测试，当前台以get请求数据时“name=zhouwd&age=10”的时候，如果对象使用了@RequestBody注释，则会响应失败。
 * 当前台以post请求数据时：
 * 第一，必须将请求数据包装成JSON格式;
 * 第二，必须在controller对应的方法的对象参数前加上@RequestBody注解
 */
@RestController
@RequestMapping("/learn")
public class TestController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/testRb")
    @ResponseBody
    public void testRb(@RequestParam String name, @RequestParam Integer age) {
        System.out.println(name + ":" + age);
    }

    @RequestMapping(value = "/testCustomObj")
    @ResponseBody
    public Employee testCustomObj(@RequestBody Employee e) {
        return e;
    }

    @RequestMapping(value = "/testCustomObjWithRp")
    @ResponseBody
    public String testCustomObjWithRp(Employee e) {

        return e.toString()+"dddd";
    }


    @RequestMapping("/testDate")
    public ModelAndView testDate(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		System.out.println("method: testDate");
		System.out.println(date);

		return new ModelAndView("result").addObject("date",date);
    }

    @RequestMapping("/xmlOrJson")
    @ResponseBody
    public Map<String, Object> xmlOrJson() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", employeeService.list());
        return map;
    }

    @RequestMapping("/innerTest")
    @ResponseBody
    public Map<String, Object> innerTest(InnerTest it) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(it.getName(), employeeService.list());
        return map;
    }

    public static class InnerTest {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }


}