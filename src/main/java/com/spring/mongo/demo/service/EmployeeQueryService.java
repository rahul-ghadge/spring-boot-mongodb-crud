package com.spring.mongo.demo.service;

import java.util.List;

import com.spring.mongo.demo.model.Employee;

public interface EmployeeQueryService {
	
	List<Employee> get();

	List<Employee> getEmployeeByFName(Employee employee);

	Employee getSingleEmployeeByFName(Employee employee);

	Employee getSingleEmployeeByLName(Employee employee);

	List<Employee> getEmployeeBySalary(Employee employee);

	List<Employee> getEmployeeByCondition(Employee employee);

	
}
