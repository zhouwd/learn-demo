package com.joe.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.joe.spring.dto.Employee;

@Service(value = "employeeService")
@Scope(value = "singleton")
public class EmployeeServiceImpl implements EmployeeService {

	Logger logger = LoggerFactory.getLogger("monitor");

    @Override
    public List<Employee> list() {
        List<Employee> list = new ArrayList<Employee>();
		Employee employee = new Employee("zhou", 10);
		list.add(employee);
		logger.info("employee:"+employee);
        return list;
    }
}
