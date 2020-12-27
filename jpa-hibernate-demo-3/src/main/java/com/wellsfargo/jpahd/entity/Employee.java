package com.wellsfargo.jpahd.entity;

import java.io.Serializable;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



 @Entity
 /*@Table(name="All_EMPS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "etype",discriminatorType = DiscriminatorType.STRING )
@DiscriminatorValue("E") */

/*@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="emps_main") */
 
 @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
 @Table(name="emps_only")


//@NamedQueries
//(
// {
//	@NamedQuery(name = "listEmpsInBasicRange", query ="SELECT e FROM Employee e WHERE e.basic BETWEEN :limit1 AND :limit2 "),
//	@NamedQuery(name= "listEmpsWithLastName",query="SELECT e FROM Employee e WHERE e.lastName=:lnm")
//    }
// )


public class Employee implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="empId")
	private Long employeeID;
	
	@Column(name="empName",nullable=false)
	private String employeeName;
	
	

	@Column(name="empSal",nullable=false)
	private Double employeeSalary;
	

	
	
	public  Employee() {
		// TODO Auto-generated constructor stub
	 
		
	}


	

	public Employee(Long employeeID, String employeeName, Double employeeSalary) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}




	public Long getEmployeeID() {
		return employeeID;
	}




	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}




	public String getEmployeeName() {
		return employeeName;
	}




	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}




	public Double getEmployeeSalary() {
		return employeeSalary;
	}




	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}




	

}
