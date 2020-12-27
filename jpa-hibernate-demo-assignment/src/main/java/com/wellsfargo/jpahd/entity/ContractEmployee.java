package com.wellsfargo.jpahd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

 @Entity
//@DiscriminatorValue("M")
//@Table(name = "emps_m")
@Table(name = "emps_m_only")

public class ContractEmployee extends Employee {
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  @Column(name="alwnc")
       private Double allowence;
       
       public ContractEmployee() {
    	   
       }

	public ContractEmployee(Long employeeID, String employeeName, Double employeeSalary, Double allownce) {
		super(employeeID, employeeName, employeeSalary);
		this.allowence=allownce;
		// TODO Auto-generated constructor stub
	}

	public Double getAllowence() {
		return allowence;
	}

	public void setAllowence(Double allowence) {
		this.allowence = allowence;
	}

	
       
}
