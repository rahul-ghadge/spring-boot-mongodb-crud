package com.spring.mongo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.service.EmployeeQueryService;

@RestController
@RequestMapping("/employee-query")
public class EmployeeQueryController {

    @Autowired
    private EmployeeQueryService employeeQueryService;

    @GetMapping
    public List<Employee> get() {
        return employeeQueryService.get();
    }

    // get employee by first name (equals())
    @PostMapping("/get-by-firstName")
    public List<Employee> getEmployeeByFirstName(@RequestBody Employee employee) {
        return employeeQueryService.getEmployeeByFName(employee);
    }


    // get employee by first name (equals())
    @PostMapping("/get-one-by-firstName")
    public Employee getSingleEmployeeByFirstName(@RequestBody Employee employee) {
        return employeeQueryService.getSingleEmployeeByFName(employee);
    }

    // get employee by last name (equals())
    @PostMapping("/get-one-by-lastName")
    public Employee getSingleEmployeeByLastName(@RequestBody Employee employee) {
        return employeeQueryService.getSingleEmployeeByLName(employee);
    }

    @PostMapping("/get-by-salary")
    public List<Employee> getEmployeeBySalary(@RequestBody Employee employee) {
        return employeeQueryService.getEmployeeBySalary(employee);
    }

    @PostMapping("/get-by-condition")
    public List<Employee> getEmployeeByCondition(@RequestBody Employee employee) {
        return employeeQueryService.getEmployeeByCondition(employee);
    }

}
