package com.wellsfargo.fsd.cms.test;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.wellsfargo.fsd.cms.dao.ContactRepositry;
import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;
import com.wellsfargo.fsd.cms.service.ContactService;
import com.wellsfargo.fsd.cms.service.ContactzServiceImpl;

@SpringJUnitConfig
public class ContactServiceIntegrationTest {
	
	@Autowired
	private ContactRepositry contactRepo;
	
	@Autowired
	private ContactService contactService;
	
	private Contact[] testData;
	
	public void setUp() {
		testData=new Contact[] {
				new Contact(101,"Amirs",LocalDate.of(1998,Month.APRIL, 11),"9876543212","FAMILY",true),
				new Contact(102,"Amir Toy",LocalDate.of(1998,Month.APRIL, 10),"9876543210","GYM",false),
				new Contact(101,"Amir Hoj",LocalDate.of(1998,Month.APRIL, 12),"9876543214","HELPERS",true),
		};
		for(Contact c:testData) {
			contactRepo.saveAndFlush(c);
		}
	}
	
	@AfterEach
	public void tearDown() {
		for(Contact c:testData) {
			contactRepo.deleteAll();
			testData=null;
			
		}
	}
	
	@Test
	public void whenAdd_givenNewContact_shouldReturnThatContact() throws ContactException {
		
		Contact contact=new Contact(101,"Amirs",LocalDate.of(1998,Month.APRIL, 11),"9876543212","FAMILY",true);
		
		assertEquals(contactService.add(contact), contact);
	}
	
	@Test
	public void whenAdd_givenExistingContact_shouldReturnThatContact() throws ContactException {
		
		Contact contact=new Contact(101,"Amirs",LocalDate.of(1998,Month.APRIL, 11),"9876543212","FAMILY",true);
	
		assertThrows(ContactException.class,()->{contactService.add(contact);});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
