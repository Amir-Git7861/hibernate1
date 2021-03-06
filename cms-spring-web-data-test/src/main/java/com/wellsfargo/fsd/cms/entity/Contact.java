package com.wellsfargo.fsd.cms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="contacts")
public class Contact {
	
	@Id
	@NotNull(message="ContactId is required")
	@Min(value=1,message="Contact id can not be zero or negative")
	private Integer contactId;
	
	@Column(name="fnm")
	@NotNull(message="FullName is required")
	@NotBlank(message="FullName is required")
	@Size(min=5,max=25,message="fullName is required to be 5 to 25 chars in length")
	private String fullName;
	
	@Column(name="dob")
	@DateTimeFormat(iso=ISO.DATE)
	@PastOrPresent(message="Date of Birth can not be future date")
	private LocalDate dateOfBirth;
	
	@Column(name="mno")
	@Pattern(regexp = "[1-9][0-9]{9}",message="Mobile no. should be 10 digits only ")
	private String mobile;
	
	@Column(name="grp")
	private String group;
	
	@Column(name="married")
	private Boolean married;
	
	public Contact() {
		// left umimplemented;
	}

	

	public Contact(
			@NotNull(message = "ContactId is required") @Min(value = 1, message = "Contact id can not be zero or negative") Integer contactId,
			@NotNull(message = "FullName is required") @NotBlank(message = "FullName is required") @Size(min = 5, max = 25, message = "fullName is required to be 5 to 25 chars in length") String fullName,
			@PastOrPresent(message = "Date of Birth can not be future date") LocalDate dateOfBirth,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "Mobile no. should be 10 digits only ") String mobile,
			String group, Boolean married) {
		super();
		this.contactId = contactId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
		this.group = group;
		this.married = married;
	}



	

	public Integer getContactId() {
		return contactId;
	}



	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getGroup() {
		return group;
	}



	public void setGroup(String group) {
		this.group = group;
	}



	public Boolean getMarried() {
		return married;
	}



	public void setMarried(Boolean married) {
		this.married = married;
	}



	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth
				+ ", mobile=" + mobile + ", group=" + group + ", married=" + married + "]";
	}



	

}
