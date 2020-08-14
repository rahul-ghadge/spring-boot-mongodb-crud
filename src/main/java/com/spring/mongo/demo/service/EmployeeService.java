package com.spring.mongo.demo.service;


import java.util.List;

import com.spring.mongo.demo.model.Employee;

public interface EmployeeService {
	
	List<Employee> get();
	
	Employee getEmployeeByName(Employee employee);
	
	Employee getEmployee(Employee employee);
	
	Employee getEmployeeBylName(Employee employee);
	
	Employee getEmployeeByFirstName(Employee employee);
	
	List<Employee> getEmployeeByFrName(Employee employee);
	
	List<Employee> getEmployeeByWhereSalary(Employee employee);
	
	List<Employee> getEmployeeByCondition(Employee employee);
	
	
	
	
}
