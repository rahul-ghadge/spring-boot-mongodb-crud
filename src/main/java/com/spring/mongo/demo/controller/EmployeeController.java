package com.spring.mongo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.service.EmployeeService;

@RestController
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
	

	@PostMapping("get-employee-by-id")
	@ResponseBody
	public Employee getEmployee(@RequestBody Employee employee) {
		return employeeService.getEmployee(employee);
	}
	
	@PostMapping("get-employee-by-fname")
	@ResponseBody
	public Employee getEmployeeByName(@RequestBody Employee employee) {
		return employeeService.getEmployeeByName(employee);
	}

	// get employee by last name(Done! question - searching by lName it only showing
	// 1 result)
	@PostMapping("get-employee-by-lname")
	@ResponseBody
	public Employee getEmployeeBylName(@RequestBody Employee employee) {
		return employeeService.getEmployeeBylName(employee);
	}

	// get employee by fname (equals())(Done)
	@PostMapping("get-employee-by-firstName")
	@ResponseBody
	public Employee getEmployeeByFirstName(@RequestBody Employee employee) {
		return employeeService.getEmployeeByFirstName(employee);
	}
		
	// get employee by fname (contains())(Done! Question - Searching by Upper Case &
	// lower case)
	@PostMapping("get-employee-by-frName")
	@ResponseBody
	public List<Employee> getEmployeebyFrName(@RequestBody Employee employee) {
		return employeeService.getEmployeebyFrName(employee);
	}

	// get employee where salary > 5000.0d(not running)
	@PostMapping("get-employee-with-salary")
	@ResponseBody
	public List<Employee> getEmployeebyWhereSalary(@RequestBody Employee employee) {
		return employeeService.getEmployeebyWhereSalary(employee);
	}
	
	@PostMapping("get-employee-by-condition")
	@ResponseBody
	public List<Employee> getEmployeebyCondition(@RequestBody Employee employee) {
		return employeeService.getEmployeebyCondition(employee);
	}
}




// Practices 1

// add 7 more employees(Done)
// get employee by last name(Done! question - searching by lName it only showing 1 result)
// get employee by fname (equals())(Done)
// get employee by fname (contains())(Done! Question - Searching by Upper Case & lower case)
// get employee where salary > 5000.0d(not running)

// ---------------------------------------------------------------------------
// Practice 2
// 
// Send empId, firstName, lastName and salary in request
// check for matching employee

// check employee object not null (null != emp)
// check properties of emp object not null (String) && greater than > 0 (Number)
// check each number and String type and return list of employee




// --------------------------------------------------------------------------
// Practice 3

// Play with above API's with different input requests (in DEBUG mode)