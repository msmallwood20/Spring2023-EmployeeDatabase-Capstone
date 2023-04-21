package edu.group3.EmployeeManagement;

import org.junit.Assert;
import org.junit.Test;

import edu.group3.EmployeeManagement.models.User;



public class UserTest {

	@Test
	public void testUserEmail() {
		
		//Testing for correct email
		
		User actualUser = new User();
		actualUser.setEmail("mikegomez@gmail.com");
		
		
		User expectedUser = new User();
		expectedUser.setEmail("mikegomez@gmail.com");
		
		Assert.assertEquals(expectedUser, actualUser);
		
		
		Assert.assertEquals("mikegomez@gmail.com", actualUser.getEmail());
		
	}
	
	
	@Test
	public void testUserFirstName() {
		
		//Simple test for CORRECT user first name
		
		User user = new User();
		user.setFirstName("Mike");
		
		Assert.assertEquals("Mike", user.getFirstName());
	}
	
	
	@Test
	public void testUserLastName() {
		
		//Likewise, simple test for CORRECT user last name 
		
		User user = new User();
		user.setLastName("Gomez");
		
		Assert.assertEquals("Gomez", user.getLastName());	
	
	}
	
	@Test 
	public void testUserFullName() {
		
		//Create an instance of the User class
		User user = new User();
		
		//Specify the users full name for the object
		user.setFullName("Mike Gomez");
		
		//Retrieve the users full name from the object
		String userFullName = user.getFullName();
		
		
		//Verify that the retrieved value for the name is accurate
		Assert.assertEquals("Mike Gomez", userFullName);
	}
	
	
    @Test
    public void testUserIdValue() {
    	
    	//User ID test
    	
    	User user = new User();
    	
    	
    	user.setId(17);
    	
    	int actualUserId = user.getId();
    	
    	Assert.assertEquals(17, actualUserId);
    	
    }
    
    @Test
    public void testUserPassword() {

    	//Password test
    	
    	User user = new User();
    	
    	
    	user.setPassword("arcticFox15");
    	
    	String actualUserPassword = user.getPassword();
    	
    	Assert.assertEquals("arcticFox15", actualUserPassword);
    	
    	
    }
    
    @Test
    public void testUserUsername() {

    	//Username test
    	
    	User user = new User();
    	
    	
    	user.setUsername("ripjaw424");
    	
    	String actualUserUsername = user.getUsername();
    	
    	Assert.assertEquals("ripjaw424", actualUserUsername);
    	
    	
    }
}
