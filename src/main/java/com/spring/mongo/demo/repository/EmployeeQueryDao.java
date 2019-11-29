package com.spring.mongo.demo.repository;

import java.util.List;

import com.spring.mongo.demo.model.Employee;

public interface EmployeeQueryDao {
	
	List<Employee> get();

	List<Employee> getEmployeeByFirstName(String firstName);

	Employee getSingleEmployeeByFirstName(String firstName);

	Employee getSingleEmployeeByLastName(String lastName);

	List<Employee> getSalary(float salary);

	
}
