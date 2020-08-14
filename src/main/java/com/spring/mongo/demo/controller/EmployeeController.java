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

	@GetMapping("say")
	public String sayHello() {
		return "Hello Spring boot";
	}
	
	@GetMapping
	public List<Employee> get() {
		return employeeService.get();
	}
	

	@PostMapping("get-by-id")
	public Employee getEmployee(@RequestBody Employee employee) {
		return employeeService.getEmployee(employee);
	}
	
	@PostMapping("get-by-firstname")
	public Employee getEmployeeByName(@RequestBody Employee employee) {
		return employeeService.getEmployeeByName(employee);
	}

	@PostMapping("get-by-lastname")
	public Employee getEmployeeBylName(@RequestBody Employee employee) {
		return employeeService.getEmployeeBylName(employee);
	}

	@PostMapping("get-employee-by-firstName")
	public Employee getEmployeeByFirstName(@RequestBody Employee employee) {
		return employeeService.getEmployeeByFirstName(employee);
	}
		
	@PostMapping("get-employee-by-frName")
	public List<Employee> getEmployeeByFrName(@RequestBody Employee employee) {
		return employeeService.getEmployeeByFrName(employee);
	}

	@PostMapping("get-employee-with-salary")
	public List<Employee> getEmployeeByWhereSalary(@RequestBody Employee employee) {
		return employeeService.getEmployeeByWhereSalary(employee);
	}
	
	@PostMapping("get-employee-by-condition")
	public List<Employee> getEmployeeByCondition(@RequestBody Employee employee) {
		return employeeService.getEmployeeByCondition(employee);
	}
}




