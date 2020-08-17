package com.spring.mongo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee-jpa")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/say")
	public String sayHello() {
		return "Hello Spring boot";
	}
	
	@GetMapping
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	

	@GetMapping("/{empId}")
	public Employee getEmployeeById(@PathVariable int empId ) {
		return employeeService.getEmployeeById(empId);
	}
	
	@GetMapping("/firstName/{firstName}")
	public List<Employee> getEmployeeByName(@PathVariable String firstName ) {
		return employeeService.getEmployeeByFirstName(firstName);
	}

	// get employee by first name (equals())
	@GetMapping("/one-by-firstName/{firstName}")
	public Employee getOneEmployeeByFirstName(@PathVariable String firstName) {
		return employeeService.getOneEmployeeByFirstName(firstName);
	}

	// get employee by first name %LIKE%
	@GetMapping("/firstName-like/{firstName}")
	public List<Employee> getEmployeeByFirstNameLike(@PathVariable String firstName) {
		return employeeService.getEmployeeByFirstNameLike(firstName);
	}

	@GetMapping("/one-by-lastName/{lastName}")
	public Employee getEmployeeBylName(@PathVariable String lastName) {
		return employeeService.getEmployeeByLastName(lastName);
	}


	@GetMapping("/salary-greater-than/{salary}")
	public List<Employee> getEmployeeBySalaryGreaterThan(@PathVariable int salary) {
		return employeeService.getEmployeeBySalaryGreaterThan(salary);
	}
	
	@PostMapping("/get-by-condition")
	public List<Employee> getEmployeeByCondition(@RequestBody Employee employee) {
		return employeeService.getEmployeeByCondition(employee);
	}
}




