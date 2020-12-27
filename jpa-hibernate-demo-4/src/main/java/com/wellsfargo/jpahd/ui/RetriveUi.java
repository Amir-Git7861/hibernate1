package com.wellsfargo.jpahd.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wellsfargo.jpahd.entity.RegularEmployee;
import com.wellsfargo.jpahd.entity.Employee;
import com.wellsfargo.jpahd.entity.ContractEmployee;

public class RetriveUi {
	public static void main(String args[]) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em=emf.createEntityManager();
		 
		final String eQry="SELECT e FROM Employee e";
		final String mQry="SELECT m FROM Manager m";
		final String ceQry="SELECT e FROM ContactEmployee e";
		
		List<Employee> emps=em.createQuery(eQry, Employee.class).getResultList();
		
		for(Employee e:emps) {
			System.out.println(e.getFirstName());
		}
		List<ContractEmployee> mgrs=em.createQuery(mQry, ContractEmployee.class).getResultList();
		
		for(ContractEmployee m:mgrs) {
			System.out.println(m.getFirstName());
		}
		List<RegularEmployee> cemps=em.createQuery(ceQry, RegularEmployee.class).getResultList();
		
		for(RegularEmployee e:cemps) {
			System.out.println(e.getFirstName());
		}
		em.close();
	}

}
