package com.wellsfargo.jpahd.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

 @Entity
//@DiscriminatorValue("C")
//@Table(name = "emps_C")
 @Table(name = "emps_c_only")

public class ContactEmployee extends Employee {
	
	
	
	@Column(name = "cDur")
	private Integer contractDuration;
	
	public ContactEmployee() {
		
	}

	public ContactEmployee(Long empNo, String firstName, String lastName, Double basic, LocalDate joinDate, 
			               Integer contractDuration) {
		super(empNo, firstName, lastName, basic, joinDate);
		this.contractDuration=contractDuration;
	}

	public Integer getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(Integer contractDuration) {
		this.contractDuration = contractDuration;
	}
	
}
	
	
	
	

