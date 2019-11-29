package com.spring.mongo.demo.response;

import java.util.List;

import com.spring.mongo.demo.model.Student;

public class StudentResponse {

	private List<Student> students;
	private int noOfStudent;

	private String status;

	
	
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getNoOfStudent() {
		return noOfStudent;
	}

	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
