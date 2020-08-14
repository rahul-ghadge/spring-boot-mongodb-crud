package com.spring.mongo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.service.EmployeeQueryService;

@RestController
public class EmployeeQueryController {

    @Autowired
    private EmployeeQueryService employeeQueryService;

    @GetMapping("/query")
    public List<Employee> get() {
        return employeeQueryService.get();
    }

    // get employee by fname (equals())(Done)
    @PostMapping("/query-get-employee-by-firstName/")
    public List<Employee> getEmployeeByFirstName(@RequestBody Employee employee) {
        return employeeQueryService.getEmployeeByFName(employee);
    }


    // get employee by fname (equals())(Done)
    @PostMapping("/query-single-employee-by-firstName")
    public Employee getSingleEmployeeByFirstName(@RequestBody Employee employee) {
        return employeeQueryService.getSingleEmployeeByFName(employee);
    }

    // get employee by lname (equals())(Done)
    @PostMapping("/query-single-employee-by-lastName")
    public Employee getSingleEmployeeByLastName(@RequestBody Employee employee) {
        return employeeQueryService.getSingleEmployeeByLName(employee);
    }

    @PostMapping("/query-get-employee-by-salary")
    public List<Employee> getEmployeeBySalary(@RequestBody Employee employee) {
        return employeeQueryService.getEmployeeBySalary(employee);
    }

    @PostMapping("/query-get-employee-by-condition")
    public List<Employee> getEmployeeByCondition(@RequestBody Employee employee) {
        return employeeQueryService.getEmployeeByCondition(employee);
    }

}
