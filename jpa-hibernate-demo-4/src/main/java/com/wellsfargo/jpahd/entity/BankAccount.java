package com.wellsfargo.jpahd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "baccs")

public class BankAccount implements Serializable{
	
	@Id
	@Column(name="acno")
	private Long accNum;
	private String brancj;
	private String bank;
	
	@OneToOne
	@JoinColumn(name = "ach")
	private Employee accountHolder;
	
	public BankAccount() {
		
		
	}

	public BankAccount(Long accNum, String brancj, String bank, Employee accountHolder) {
		super();
		this.accNum = accNum;
		this.brancj = brancj;
		this.bank = bank;
		this.accountHolder = accountHolder;
	}

	public Long getAccNum() {
		return accNum;
	}

	public void setAccNum(Long accNum) {
		this.accNum = accNum;
	}

	public String getBrancj() {
		return brancj;
	}

	public void setBrancj(String brancj) {
		this.brancj = brancj;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Employee getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Employee accountHolder) {
		this.accountHolder = accountHolder;
	}
	

}
