package com.wells.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.wells.model.Employee;

public class StreamDemo {

	public static void main(String[] args) {
		List<Employee> emps=Arrays.asList(new Employee[] {
				new Employee(109L, "Amir", 90000.0,LocalDate.of(1990, Month.JANUARY, 1)),
				new Employee(103L, "Sohel", 90000.0,LocalDate.of(1990, Month.JANUARY, 11)),
				new Employee(102L, "Sameer", 85000.0,LocalDate.of(1990, Month.JANUARY, 21)),
				new Employee(110L, "Kajal", 92000.0,LocalDate.of(1990, Month.JANUARY, 16)),
				new Employee(101L, "jack", 87000.0,LocalDate.of(1990, Month.JANUARY, 10)),
				new Employee(119L, "King", 86000.0,LocalDate.of(1990, Month.JANUARY, 5)),
		});
		emps.stream().forEach(System.out::println);
		emps.stream().forEach((emp) -> {emp.setBasic(emp.getBasic()+5000);});
		System.out.println("--------------------------------------------------");
		emps.stream().forEach(System.out::println);
		
		System.out.println("--------------------------------------------------");
		Optional<Employee> result=emps.stream().reduce((e1,e2) -> e1.getHireDate().isBefore(e2.getHireDate())?e1:e2);
		if(result.isPresent()) {
			System.out.println(result.get());
		}
		System.out.println("--------------------------------------------------");
		Employee junior=emps.stream().reduce((e1,e2) -> e1.getHireDate().isAfter(e2.getHireDate())?e1:e2).orElse(null);
		System.out.println(junior);
		
		System.out.println("--------------------------------------------------");
		emps.stream().filter((emp) -> emp.getBasic()<=95000).forEach(System.out::println);
		
		System.out.println("--------------------------------------------------");
		List<Employee> emps2=emps.stream().filter((emp) -> emp.getBasic()<=95000).collect(Collectors.toList());
		System.out.println(emps2);
		
		System.out.println("--------------------------------------------------");
		emps.stream().map((emp) ->emp.getName()).forEach(System.out::println);
		
	}

}
