package com.wellsfargo.jpahd.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

 @Entity
//@DiscriminatorValue("M")
//@Table(name = "emps_m")
@Table(name = "emps_m_only")

public class Manager extends Employee {
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  @Column(name="alwnc")
       private Double allowence;
       
       public Manager() {
    	   
       }

	public Manager(Long empNo, String firstName, String lastName, Double basic, LocalDate joinDate, Double allowence) {
		super(empNo, firstName, lastName, basic, joinDate);
		this.allowence=allowence;
	}

	public Double getAllowence() {
		return allowence;
	}

	public void setAllowence(Double allowence) {
		this.allowence = allowence;
	}
	
       
}
