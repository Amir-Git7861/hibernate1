package com.wellsfargo.jpahd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.wellsfargo.jpahd.entity.Employee;

public class EmployeeApp {
	
	
	public static void main(String[] args) {
		
		Employee[] emps=new Employee[] {
				new Employee(101L,"Amir","Sohel",25000.0,LocalDate.now()),
				new Employee(102L,"Sammer","Vats",35000.0,LocalDate.now()),
				new Employee(103L,"Shekhar","Khanna",55000.0,LocalDate.now()),
				new Employee(104L,"Sumit","Shaw",45000.0,LocalDate.now()),
				new Employee(105L,"Ausaf","Shamin",75000.0,LocalDate.now()),
				
		};
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction txn=em.getTransaction();
		txn.begin();
		
		for(Employee emp:emps) {
			em.persist(emp);
			System.out.println("Employee is saved");
		}
		
		txn.commit();
		em.close();
	}

}
