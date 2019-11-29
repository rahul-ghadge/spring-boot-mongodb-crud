package com.spring.mongo.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.repository.EmployeeQueryDao;


@Repository
class EmployeeQueryDaoImpl implements EmployeeQueryDao {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Employee> get() {
		System.out.println("Inside Employee Qyery DAO Impl's get()");		
		return mongoTemplate.findAll(Employee.class);
	}

	
	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		
		List<Employee> employees = new ArrayList<>();
		
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is(firstName));
		employees.addAll(mongoTemplate.find(query, Employee.class));
		
		
		return employees;
	}



	@Override
	public Employee getSingleEmployeeByFirstName(String name) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is(name));
		
		return mongoTemplate.findOne(query, Employee.class);
		
	}
	
	
	
	// "firstName"  --> database property (not related to java code)
	// select * from employee where lastName like %Gurung% limit 1 --> (case insensitive)
	
	@Override
	public Employee getSingleEmployeeByLastName(String lastName) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("lastName").regex(lastName, "i"));
		
		return mongoTemplate.findOne(query, Employee.class);
		
	}

	
	@Override
	public List<Employee> getSalary(float salary) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("salary").gt(salary));
		//query.addCriteria(Criteria.where("salary").gt(4000));
		query.with(new Sort(Sort.Direction.ASC, "firstName"));
		
		return mongoTemplate.find(query, Employee.class);
	}
	
	
	
	
	
	
	

}
