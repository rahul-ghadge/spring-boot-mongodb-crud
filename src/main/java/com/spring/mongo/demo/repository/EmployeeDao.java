package com.spring.mongo.demo.repository;

import java.util.List;

import com.spring.mongo.demo.model.Employee;

public interface EmployeeDao {
	
	List<Employee> getEmployeeByFirstName(String firstName);

}
