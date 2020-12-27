package com.wellsfargo.jpahd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

 @Entity
//@DiscriminatorValue("C")
//@Table(name = "emps_C")
 @Table(name = "emps_c_only")

public class RegularEmployee extends Employee {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "qplc")
	private Integer qplc;
	
	public RegularEmployee() {
		
	}

	
	public RegularEmployee(Long employeeID, String employeeName, Double employeeSalary,Integer qplc) {
		super(employeeID, employeeName, employeeSalary);
		this.qplc=qplc;
		// TODO Auto-generated constructor stub
	}


	public Integer getQplc() {
		return qplc;
	}

	public void setQplc(Integer qplc) {
		this.qplc = qplc;
	}

 }
	
	
	

