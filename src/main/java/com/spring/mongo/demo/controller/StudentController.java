package com.spring.mongo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.demo.model.Student;
import com.spring.mongo.demo.response.StudentResponse;
import com.spring.mongo.demo.utils.HelperUtil;

@RestController
public class StudentController {

	@Value("${application.developer}")
	private String developer;

	// @Value("${application.name}")
	// private String application;

	@GetMapping("get-student/{studentName}/{pageNo}")
	public void getStudentByNameWithPage(@PathVariable("pageNo") String page, @PathVariable String studentName) {

		System.out.println(studentName);
		int pageNumber = Integer.parseInt(page);

		int c = pageNumber * 10;
		System.out.println(c);

	}

	@GetMapping("get-student/{firstName}")
	public String getStudentByName(@PathVariable String firstName) {

		System.out.println(firstName);

		List<Student> list = HelperUtil.getStaticStudent();

		String fullName = "";

		for (Student student : list) {
			if (student.getFirstName().equalsIgnoreCase(firstName))
				fullName = student.getFirstName() + " " + student.getLastName();
		}
		return fullName;

	}

	@GetMapping("get-percentage/{firstName}")
	public String getStudentPercentage(@PathVariable String firstName) {

		float percentage = 0.0f;
		String finalResponse = "";
		List<Student> list = HelperUtil.getStaticStudent();

		for (Student student : list) {
			if (student.getFirstName().equalsIgnoreCase(firstName)) {
				percentage = (student.getMarks() * 100) / student.getTotal();

				finalResponse = student.getFirstName() + " got " + percentage + "%";

			}
		}
		return finalResponse;

	}

	// localhost:8083/get-percentage/binay ---> @PathVariable --> get request
	// https://www.youtube.com/watch ? var=yIvJTMsuqzM ---> @RequestParam --> get
	// request

	// localhost:8083/get-percentage?name=binay
	@GetMapping("percentage")
	public String getStudent(@RequestParam("name") String firstName) {

		float percentage = 0.0f;
		String finalResponse = "";
		List<Student> list = HelperUtil.getStaticStudent();

		for (Student student : list) {
			if (student.getFirstName().equalsIgnoreCase(firstName)) {
				percentage = (student.getMarks() * 100) / student.getTotal();

				finalResponse = student.getFirstName() + " got " + percentage + "%";

			}
		}
		return finalResponse;

	}

	@GetMapping("get-student-by-last-name/{lastName}")
	public String getStudentByLastName(@PathVariable String lastName) {

		// System.out.println(lastName);

		System.out.println(developer);

		List<Student> list = HelperUtil.getStaticStudent();

		String fullName = "";

		for (Student student : list) {
			if (student.getLastName().equalsIgnoreCase(lastName)) {
				fullName = student.getRollNo() + " " + student.getFirstName() + " " + student.getLastName() + " "
						+ student.getMarks();
				break;
			}
		}
		return fullName;

	}

	// Practice 1 (25 July, 2019)
	// change return type as List
	// initialize machining list
	// check condition and it satisfies then add that object to matching list
	// return machining list

	// look into @Value annotation

	// complete below API

	// refer "get-employee-by-condition" for more details

	@GetMapping("get-student-response/{lastName}")
	public StudentResponse getStudentResponseByLastName(@PathVariable String lastName) {

		StudentResponse response = new StudentResponse();
		List<Student> students = new ArrayList<>();
		
		// here you get the list from DB
		List<Student> list = HelperUtil.getStaticStudent();


		for(int i = 0; i < list.size(); i++) {
			
			Student student = list.get(i);
			
			
			// -----------------------------------------------------------------------
			if (student.getLastName().equalsIgnoreCase(lastName)) {
				students.add(student);
			}
			
			
			
			// -----------------------------------------------------------------------
			
			
		}
		
//		for (Student student : list) {
//			if (student.getLastName().equalsIgnoreCase(lastName)) {
//				students.add(student);
//			}
//		}
		

		
		if(students.size() > 0) {
			response.setStudents(students);		
			response.setNoOfStudent(students.size());
			response.setStatus("Success");
		} else {
			response.setStatus("No student found...!");
		}
		
		return response;

	}
	@GetMapping("get-student-by-condition")
	@ResponseBody
	public List<Student> getStudentByCondition(@RequestBody Student student) {

		List<Student> list = HelperUtil.getStaticStudent();
		List<Student> matchingStudents = new ArrayList<>();

		
		// This will return true if employee object is present(not null) any one of property is not null OR greater than 0
		if (null != student && 
				(null != student.getFirstName() || student.getRollNo() > 0
				|| null != student.getLastName() || student.getMarks() > 0)) {
			
			
			for (@SuppressWarnings("unused") Student stu : list) {
				
				
				// If all 4 properties are present then only this block will execute
				if (null != student.getFirstName() && student.getRollNo() > 0
						&& null != student.getLastName() && student.getMarks() > 0) {
					
					if (student.getRollNo() == student.getRollNo() 
							&& student.getFirstName().equalsIgnoreCase(student.getFirstName())
							&& student.getLastName().equalsIgnoreCase(student.getLastName())
							&& student.getMarks() == student.getMarks() ) {
					matchingStudents.add(student);
						// Break the for loop
						break;						
					} else {
						// Go back to first statement (nothing but for loop)
						continue;
					}
				}
				// ----------------------------------------------------------------
				
				
				// if any one of above property is null or less than equals to 0 then below block is executing
				
				// Student RollNo
				if (student.getRollNo() == student.getRollNo()) {
					matchingStudents.add(student);
					// Go back to first statement (nothing but for loop)
					continue;
				}

				// First name
				if (null != student.getFirstName()) {
					if (student.getFirstName().toLowerCase().contains(student.getFirstName().toLowerCase())) {
						matchingStudents.add(student);
						// Go back to first statement (nothing but for loop)
						continue;
					}
				}

				// Last name
				if (null != student.getLastName()) {
					if (student.getLastName().equalsIgnoreCase(student.getLastName()))
						matchingStudents.add(student);
						// Go back to first statement (nothing but for loop)
						continue;
				}

				// Marks
				if (student.getMarks() == student.getMarks()) {
					matchingStudents.add(student);
					// Go back to first statement (nothing but for loop)
						continue;
				}
				return matchingStudents;
			
				}
			// returning the list
	
			return matchingStudents;

	}
		return matchingStudents;
}
}


