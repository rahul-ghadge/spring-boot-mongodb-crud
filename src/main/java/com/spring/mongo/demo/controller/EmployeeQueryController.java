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
    public List<Employee> getAll() {
        return employeeQueryService.getAll();
    }


    // getAll employee by first name (equals())
    @GetMapping("/firstName/{firstName}")
    public List<Employee> getEmployeeByFirstName(@PathVariable String firstName) {
        return employeeQueryService.getEmployeeByFirstName(firstName);
    }


    // getAll employee by first name (equals())
    @GetMapping("/one-by-firstName/{firstName}")
    public Employee getOneEmployeeByFirstName(@PathVariable String firstName) {
        return employeeQueryService.getOneEmployeeByFirstName(firstName);
    }

    // getAll employee by first name %LIKE%
    @GetMapping("/firstName-like/{firstName}")
    public List<Employee> getEmployeeByFirstNameLike(@PathVariable String firstName) {
        return employeeQueryService.getEmployeeByFirstNameLike(firstName);
    }


    // getAll employee by last name (equals())
    @GetMapping("/one-by-lastName/{lastName}")
    public Employee getSingleEmployeeByLastName(@PathVariable String lastName) {
        return employeeQueryService.getSingleEmployeeByLastName(lastName);
    }


    @GetMapping("/salary-greater-than/{salary}")
    public List<Employee> getEmployeeBySalaryGreaterThan(@PathVariable int salary) {
        return employeeQueryService.getEmployeeBySalaryGreaterThan(salary);
    }


    @PostMapping("/get-by-condition")
    public List<Employee> getEmployeeByCondition(@RequestBody Employee employee) {
        return employeeQueryService.getEmployeeByCondition(employee);
    }

}
