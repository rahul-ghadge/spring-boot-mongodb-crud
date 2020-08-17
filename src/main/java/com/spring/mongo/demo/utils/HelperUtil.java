package com.spring.mongo.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.spring.mongo.demo.model.Employee;
import com.spring.mongo.demo.model.SuperHero;

public class HelperUtil {

    private HelperUtil() {
    }


    public static Supplier<List<Employee>> employeeSupplier = () ->
            Arrays.asList(
		            Employee.builder().empId(1).firstName("Binay").lastName("Gurung").salary(3000.0f).build(),
		            Employee.builder().empId(2).firstName("Rahul").lastName("Ghadage").salary(4000.0f).build(),
		            Employee.builder().empId(3).firstName("Sunny").lastName("Deol").salary(5000.0f).build(),
		            Employee.builder().empId(4).firstName("Salman").lastName("Khan").salary(6000.0f).build(),
		            Employee.builder().empId(5).firstName("Aamir").lastName("Khan").salary(7000.0f).build(),
		            Employee.builder().empId(6).firstName("Shahrukh").lastName("Khan").salary(8000.0f).build(),
		            Employee.builder().empId(7).firstName("Ranbir").lastName("Kapoor").salary(9000.0f).build(),
		            Employee.builder().empId(8).firstName("Ranveer").lastName("Singh").salary(10000.0f).build(),
		            Employee.builder().empId(9).firstName("Akshay").lastName("Kumar").salary(11000.0f).build(),
		            Employee.builder().empId(10).firstName("Ajay").lastName("Devgan").salary(12000.0f).build()
            );



    public static Supplier<List<SuperHero>> superHeroesSupplier = () ->
            Arrays.asList(
                    SuperHero.builder().name("Wade").superName("Deadpool").profession("Street fighter").age(28).canFly(false).build(),
                    SuperHero.builder().name("Bruce").superName("Hulk").profession("Doctor").age(50).canFly(false).build(),
                    SuperHero.builder().name("Steve").superName("Captain America").profession("Solder").age(120).canFly(false).build(),
                    SuperHero.builder().name("Tony").superName("Iron Man").profession("Business man").age(45).canFly(true).build(),
                    SuperHero.builder().name("Peter").superName("Spider Man").profession("Student").age(21).canFly(true).build()
            );




//	public static List<Student> getStaticStudent() {
//
//
//		//System.out.println(developer);
//
//		List<Student> list = new ArrayList<>();
//
//		list.add(new Student(1, "Binay", "Gurung", 490, 500));
//		list.add(new Student(2, "Rahul", "Ghadage", 400, 500));
//		list.add(new Student(3, "Sunny", "Deol", 450, 500));
//		list.add(new Student(4, "Salman", "Khan", 440, 500));
//		list.add(new Student(5, "Aamir", "Khan", 400, 500));
//		list.add(new Student(6, "Sanjay", "Dutt", 420, 500));
//		list.add(new Student(7, "Sharukh", "Khan", 300, 500));
//		list.add(new Student(8, "Ranbir", "Kapoor", 320, 500));
//		list.add(new Student(9, "Ranveer", "Singh", 250, 500));
//		list.add(new Student(10, "Akshay", "Kumar", 280, 500));
//		list.add(new Student(11, "Ajay", "Devgan", 340, 500));
//		list.add(new Student(12, "Kishore", "Kumar", 399, 500));
//		list.add(new Student(13, "Bobby", "Deol", 345, 500));
//		list.add(new Student(14, "Rishi", "Kapoor", 355, 500));
//		list.add(new Student(15, "Jhon", "Abraham", 407, 500));
//		list.add(new Student(16, "Sunil", "Shetty", 421, 500));
//		list.add(new Student(17, "Manoj", "Bajpaye", 422, 500));
//		list.add(new Student(18, "Sunil", "Grover", 308, 500));
//		list.add(new Student(19, "Jhonny", "Lever", 267, 500));
//		list.add(new Student(20, "Abhishek", "Bachhan", 380, 500));
//		list.add(new Student(21, "Nitesh", "Deshmuk", 434, 500));
//		list.add(new Student(22, "Akshay", "Khanna", 402, 500));
//		list.add(new Student(23, "Arjit", "Singh", 347, 500));
//		list.add(new Student(24, "Kumar", "Sanu", 254, 500));
//		list.add(new Student(25, "Abhijit", "Babu", 344, 500));
//
//		return list;
//
//	}

}
