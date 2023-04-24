package edu.group3.EmployeeManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.group3.EmployeeManagement.models.Contact;

class ContactTest {

	@Test
	public void testContactEmail() {
		
		//Testing for correct email
		
		Contact actualContact = new Contact();
		actualContact.setEmail("johnjones@gmail.com");
		
		
		Contact expectedContact = new Contact();
		expectedContact.setEmail("johnjones@gmail.com");
		
		Assert.assertEquals(expectedContact, actualContact);
		
		
		Assert.assertEquals("johnjones@gmail.com", actualContact.getEmail());
		
	}
	
	
	@Test
	public void testContactFirstName() {
		
		//Simple test for CORRECT contact first name
		
		Contact contact = new Contact();
		contact.setFirstName("John");
		
		Assert.assertEquals("John", contact.getFirstName());
	}
	
	
	@Test
	public void testContactLastName() {
		
		//Likewise, simple test for CORRECT contact last name 
		
		Contact contact = new Contact();
		contact.setLastName("Jones");
		
		Assert.assertEquals("Jones", contact.getLastName());	
	
	}
	
	
    @Test
    public void testIdValue() {
    	
    	//Contact ID test
    	
    	Contact contact = new Contact();
    	
    	
    	contact.setId(21);
    	
    	int actualContactId = contact.getId();
    	
    	Assert.assertEquals(21, actualContactId);
    	
    }
    
    @Test
    public void testContactRemarks() {

    	//Remarks test
    	
    	Contact contact = new Contact();
    	
    	
    	contact.setRemarks("Remarks for contact");
    	
    	String actualContactRemarks = contact.getRemarks();
    	
    	Assert.assertEquals("Remarks for contact", actualContactRemarks);
    	
    	
    }

}
