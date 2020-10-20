package com.wellsfargo.jpahd.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.wellsfargo.jpahd.entity.Employee;

public class EmployeeApp3JPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em=emf.createEntityManager();
		
		String qryText="SELECT e FROM EMPLOYEE e"; //JPQL
		
		TypedQuery<Employee> empQry=em.createQuery(qryText,Employee.class);
		List<Employee> emps=empQry.getResultList();
		
		for(Employee emp:emps) {
			System.out.println(emp.getEmpNo() +"\t" + emp.getFirstName() + "\t" 
								+ emp.getLastName() + emp.getJoinDate() + "\t" +emp.getBasic()) ;
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		
		Query empNamesQry=em.createQuery("SELECT e.firstName FROM Employeee e");
		List<String> eNames=empNamesQry.getResultList();
		
		for(String n:eNames) {
			System.out.println(n);
			
		}
		
		System.out.println("-----------------------------------------------------------------------------------------");
		
		TypedQuery<Employee> empQry2=em.createQuery("SELECT e FROM Employee e WHERE e.basic", Employee.class);
		List<Employee> emps2=empQry2.getResultList();
		
		for(Employee emp:emps2) {
			System.out.println(emp.getEmpNo() +"\t" + emp.getFirstName() + "\t" 
								+ emp.getLastName() + emp.getJoinDate() + "\t" +emp.getBasic()) ;
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		


		TypedQuery<Employee> empQry3=em.createQuery("SELECT e FROM Employee e WHERE e.basic between :limit AND :limit2", Employee.class);
		empQry3.setParameter("limit1", 55000.0);
		empQry3.setParameter("limit2", 95000.0);
		List<Employee> emps3=empQry3.getResultList();
		
		for(Employee emp:emps3) {
			System.out.println(emp.getEmpNo() +"\t" + emp.getFirstName() + "\t" 
								+ emp.getLastName() + emp.getJoinDate() + "\t" +emp.getBasic()) ;
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		
		
		//NAMED QUERIES
		TypedQuery<Employee> empQry4=em.createQuery("listEmpsWithLastName", Employee.class);
		empQry4.setParameter("lnm", "Sohel");
		
		List<Employee> emps4=empQry4.getResultList();
		
		for(Employee emp:emps4) {
			System.out.println(emp.getEmpNo() +"\t" + emp.getFirstName() + "\t" 
								+ emp.getLastName() + emp.getJoinDate() + "\t" +emp.getBasic()) ;
		}
		em.close();
		
	}

}
