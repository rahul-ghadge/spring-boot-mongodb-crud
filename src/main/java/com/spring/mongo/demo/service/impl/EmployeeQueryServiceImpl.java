package com.spring.mongo.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.repository.EmployeeQueryDao;
import com.spring.mongo.demo.service.EmployeeQueryService;

@Service
public class EmployeeQueryServiceImpl implements EmployeeQueryService {

	@Autowired
	private EmployeeQueryDao employeeQueryDao;

	@Override
	public List<Employee> get() {
		System.out.println("Inside Employee Query Service Impl");
		return employeeQueryDao.get();
	}

	@Override
	public List<Employee> getEmployeeByFName(Employee employee) {

		if (null != employee && null != employee.getFirstName()) {
			String firstName = employee.getFirstName();
			return employeeQueryDao.getEmployeeByFirstName(firstName);
		}

		return null;
	}

	@Override
	public Employee getSingleEmployeeByFName(Employee employee) {

		// checking employee is not null and only then employee firstName not null
		if (null != employee && null != employee.getFirstName()) {

			// fetching first name from user request and storing it into firstName variable
			String firstName = employee.getFirstName();

			// passing user input to DAO layer
			return employeeQueryDao.getSingleEmployeeByFirstName(firstName);
		}

		return new Employee(0, "Not Found", "Please enter valid id", 0.0f);

	}

	@Override
	public Employee getSingleEmployeeByLName(Employee employee) {

		if (null != employee && null != employee.getLastName()) {
			String lastName = employee.getLastName();
			return employeeQueryDao.getSingleEmployeeByLastName(lastName);
		}
		return new Employee(0, "Not Found", "Please enter valid last name", 0.0f);
	}

	@Override
	public List<Employee> getEmployeeBySalary(Employee employee) {

		if (null != employee && employee.getSalary() > 0) {
			float salary = employee.getSalary();
			return employeeQueryDao.getSalary(salary);
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeeByCondition(Employee employee) {
		List<Employee> list = employeeQueryDao.get();
		List<Employee> matchingEmps = new ArrayList<>();

		if (null != employee && (null != employee.getFirstName() || employee.getEmpId() > 0
				|| null != employee.getLastName() || employee.getSalary() > 0)) {

			for (Employee emp : list) {

				if (null != employee.getFirstName() && employee.getEmpId() > 0 && null != employee.getLastName()
						&& employee.getSalary() > 0) {

					if (emp.getEmpId() == employee.getEmpId()
							&& emp.getFirstName().equalsIgnoreCase(employee.getFirstName())
							&& emp.getLastName().equalsIgnoreCase(employee.getLastName())
							&& emp.getSalary() == employee.getSalary()) {
						matchingEmps.add(emp);

						break;
					} else {
						continue;
					}
				}
				if (employee.getEmpId() == emp.getEmpId()) {
					matchingEmps.add(emp);
					continue;
				}

				// First name
				if (null != employee.getFirstName()) {
					if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
						matchingEmps.add(emp);
						// Go back to first statement (nothing but for loop)
						continue;
					}
				}

				// Last name
				if (null != employee.getLastName()) {
					if (emp.getLastName().equalsIgnoreCase(employee.getLastName()))
						matchingEmps.add(emp);
					// Go back to first statement (nothing but for loop)
					continue;
				}
				// salary
				if (employee.getSalary() == emp.getSalary()) {
					matchingEmps.add(emp);
					// Go back to first statement (nothing but for loop)
					continue;
				}
				// ---------------------------------------------------------
			}
			// returning the list
			return matchingEmps;
		}
		// if below statements return false only then below list is returning
		// if (null != employee &&
		// (null != employee.getFirstName() || employee.getEmpId() > 0
		// || null != employee.getLastName() || employee.getSalary() > 0))
		return matchingEmps;
	}

}
