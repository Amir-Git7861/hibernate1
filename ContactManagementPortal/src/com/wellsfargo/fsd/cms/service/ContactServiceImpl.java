package com.wellsfargo.fsd.cms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cms.dao.ContactDao;
import com.wellsfargo.fsd.cms.dao.ContactDaoJdbcImpl;
import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;

public  class ContactServiceImpl implements ContactService {
	
	
	private ContactDao contactDao;
	
	
	 public ContactServiceImpl() {
		
		 contactDao=new ContactDaoJdbcImpl();
	}
	 private boolean isValidContactID(Integer contactId) {
		 return contactId!=null && contactId>0;
	 }
	 
	 private boolean isValidFullName(String fullName) {
		 return fullName!=null && (fullName.length()>=3 || fullName.length()<=20);
	 }
	 
	 private boolean isValidDateOfBirth(LocalDate dob) {
		 return dob!=null && (!dob.isAfter(LocalDate.now()));
	 }
	 
	 private boolean isValidMobile(String mobile) {
		 return mobile!=null && mobile.matches("[1-9][0-9]{9}");
	 }
	 
	 
	 public boolean isValidContact(Contact contact) throws ContactException {
		 List<String> errMsg=new ArrayList<>();
		 boolean isValid=true;
		
		 if(contact!=null) {
			 
			 if(!isValidContactID(contact.getContactId())) {
				 isValid=false;
				errMsg.add("Contact id can not left blank and must be a positive numbers Duplicates are not allowed");
				 
				 
			 }
			 
			 if(!isValidFullName(contact.getFullName())) {
				 isValid=false;
				errMsg.add("Full Name can not left blank and must be 3 to 20 in length");
				 
				 
			 }
			 if(!isValidDateOfBirth(contact.getDateOfBirth())) {
				 isValid=false;
				errMsg.add("DOB can not left blank and must be a past date");
				 
				 
			 }
			 if(!isValidMobile(contact.getMobile())) {
				 isValid=false;
				errMsg.add("Mobile Number can not left blank and must a 10 digits");
			}
			 
			 if(!errMsg.isEmpty()) {
				 throw new ContactException("Invalid Contact:" +errMsg);
			 }
		 }else {
			 isValid=false;
			 throw new ContactException("Contact details are not supplied");
		 }
		 
		 return isValid;
		 
	 }



	@Override
	public Contact validateAndAdd(Contact contact) throws ContactException {
		
		if(isValidContact(contact)) {
			contactDao.add(contact);
		}
		
		return contact;
	}

	@Override
	public Contact validateAndSave(Contact contact) throws ContactException {
		if(isValidContact(contact)) {
			contactDao.save(contact);
		}
		
		
		return contact;
	}

	@Override
	public boolean deleteContact(int contactId) throws ContactException {
		
		return contactDao.deleteById(contactId);
	}

	public Contact getContact(int contactId) throws ContactException {
		
		return contactDao.getById(contactId);
	}

	@Override
	public List<Contact> getAllContacts() throws ContactException {
		
		return contactDao.getAll();
	}
	

}
