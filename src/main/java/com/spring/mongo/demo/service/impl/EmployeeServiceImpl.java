package com.spring.mongo.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.repository.EmployeeDao;
import com.spring.mongo.demo.repository.EmployeeRepository;
import com.spring.mongo.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	@Autowired
	private EmployeeRepository repository;
	
	
	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public List<Employee> get() {
		return repository.findAll();
	}
	
	@Override
	public Employee getEmployeeBylName(Employee employee) {
		
		List<Employee> employees = repository.findAll();
		
		for (Employee emp : employees) {
			if (emp.getLastName().equalsIgnoreCase(employee.getLastName()))
				return emp;
		}
		return new Employee().builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
	}

	@Override
	public Employee getEmployee(Employee employee) {
		List<Employee> employees = repository.findAll();
		for (Employee emp : employees) {
			if (employee.getEmpId() == emp.getEmpId())
				return emp;
		}
		return new Employee().builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
	}

	@Override
	public Employee getEmployeeByName(Employee employee) {
		List<Employee> employees = repository.findAll();
		for (Employee emp : employees) {
			if (emp.getFirstName().equalsIgnoreCase(employee.getFirstName()))
				return emp;
		}
		return new Employee().builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
	}

	@Override
	public Employee getEmployeeByFirstName(Employee employee) {
		List<Employee> list = repository.findAll();
		for (Employee emp : list) {
			if (emp.getFirstName().equals(employee.getFirstName()))
				return emp;
		}
		return new Employee().builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
	}

	@Override
	public List<Employee> getEmployeeByFrName(Employee employee) {
		List<Employee> employees = new ArrayList<>();

		if (null != employee && null != employee.getFirstName()
				&& !(employee.getFirstName().equals(""))) {
			List<Employee> list = repository.findAll();

			for (Employee emp : list) {
				if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
					employees.add(emp);
				}
			}
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeeByWhereSalary(Employee employee) {
		List<Employee> employees = new ArrayList<>();

		if (employee.getSalary() > 0) {
			List<Employee> list = repository.findAll();

			for (Employee emp : list) {
				if (emp.getSalary() > employee.getSalary())
					employees.add(emp);
			}
		}

		return employees;
	}

	
	
	
	@Override
	public List<Employee> getEmployeeByCondition(Employee employee) {
		List<Employee> list = repository.findAll();
		List<Employee> employees = new ArrayList<>();

		// This will return true if employee object is present(not null) any one of
		// property is not null OR greater than 0
		if (null != employee && (null != employee.getFirstName() || employee.getEmpId() > 0
				|| null != employee.getLastName() || employee.getSalary() > 0)) {

			for (Employee emp : list) {

				// If all 4 properties are present then only this block will execute
				if (null != employee.getFirstName() && employee.getEmpId() > 0 && null != employee.getLastName()
						&& employee.getSalary() > 0) {

					if (emp.getEmpId() == employee.getEmpId()
							&& emp.getFirstName().equalsIgnoreCase(employee.getFirstName())
							&& emp.getLastName().equalsIgnoreCase(employee.getLastName())
							&& emp.getSalary() == employee.getSalary()) {
						employees.add(emp);
						// Break the for loop
						break;
					} else {
						// Go back to first statement
						continue;
					}
				}

				// if any one of above property is null or less than equals to 0 then below
				// block is executing
				// Emp Id
				if (employee.getEmpId() == emp.getEmpId()) {
					employees.add(emp);
					// Go back to first statement
					continue;
				}

				// First name
				if (null != employee.getFirstName()) {
					if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
						employees.add(emp);
						// Go back to first statement
						continue;
					}
				}

				// Last name
				if (null != employee.getLastName()) {
					if (emp.getLastName().equalsIgnoreCase(employee.getLastName()))
						employees.add(emp);
					// Go back to first statement
					continue;
				}
				// salary
				if (employee.getSalary() == emp.getSalary()) {
					employees.add(emp);
					// Go back to first statement
					continue;
				}
				// ---------------------------------------------------------
			}
			// returning the list
			return employees;
		}
		// if below statements return false only then below list is returning
		// if (null != employee &&
		// (null != employee.getFirstName() || employee.getEmpId() > 0
		// || null != employee.getLastName() || employee.getSalary() > 0))
		return employees;
	}

}
