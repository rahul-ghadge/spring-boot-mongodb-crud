package com.spring.mongo.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.repository.EmployeeDao;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {

		List<Employee> employees = new ArrayList<>();
		
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is(firstName));	
		query.addCriteria(Criteria.where("salary").gt(4000));
		
		employees.addAll(mongoTemplate.find(query, Employee.class));
		
		return employees;
	}
	
}
