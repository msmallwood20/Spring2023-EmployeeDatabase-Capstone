/**
 * 
 */
package edu.group3.EmployeeManagementUserDetailsTest;

import edu.group3.EmployeeManagement.models.Users;
import org.junit.Assert;
import org.junit.Test;

public class UserDetailsTest {
	
	@Test
    public void testUserIdValuePass() {
    	
    	// Type variable = value;
    	// ClassName variableName = new ClassName();
    	Users user = new Users();
    	
    	// To use any method on the object: objectName.methodName();
    	user.setId(5);
    	
    	long actualUserId = user.getId();
    	
    	Assert.assertEquals(5, actualUserId);
    	
    }
    
    /*@Test
    public void testUserIdValueFail() {
    	
    	// Type variable = value;
    	// ClassName variableName = new ClassName();
    	Users user = new Users();
    	
    	// To use any method on the object: objectName.methodName();
    	user.setId(20);
    	
    	long actualUserId = user.getId();
    	
    	Assert.assertEquals(10, actualUserId);
    	
    }*/

	//In this test we want to set a password and test it
	@Test
	public void testUserPasswordPass() {
		
		Users actualUserPassword = new Users();
		actualUserPassword.setPassword("GAzebo12!!");
		
		Users expectedUserPassword = new Users();
		expectedUserPassword.setPassword("GAzebo12!!");
		
		Assert.assertEquals(expectedUserPassword, actualUserPassword);
		
		
		Assert.assertEquals("GAzebo12!!", actualUserPassword.getEmail());
		
	}
	
	/*@Test
	public void testUserPasswordFail() {
		
		Users actualUserPassword = new Users();
		actualUserPassword.setPassword("GAzebo12!!");
		
		Users expectedUserPassword = new Users();
		expectedUserPassword.setPassword("CPsc488!!");
		
		Assert.assertEquals(expectedUserPassword, actualUserPassword);
		
		
		Assert.assertEquals("GAzebo12!!", actualUserPassword.getEmail());
		
	}*/
	
	@Test
	public void testUserEmailPass() {
	
		// In this method, create a users email and retrieve the relevant email after it has been specified.
		// After the email is retrieved from the object, do the following tests
		
		Users actualUserEmail = new Users();
		actualUserEmail.setEmail("micael.felps@gmail.com");
		
		
		Users expectedUserEmail = new Users();
		expectedUserEmail.setEmail("micael.felps@gmail.com");
		
		Assert.assertEquals(expectedUserEmail, actualUserEmail);
		
		
		Assert.assertEquals("michael.felps@gmail.com", actualUserEmail.getEmail());
		
	}
	
	/*@Test
	public void testUserEmailFail() {
	
		// In this method, create a users email and retrieve the relevant email after it has been specified.
		// After the email is retrieved from the object, do the following tests and fail
		
		Users actualUserEmail = new  Users();
		actualUserEmail.setEmail("felps.michael@gmail.com");
		
		
		Users expectedUserEmail = new Users();
		expectedUserEmail.setEmail("micael.felps@gmail.com");
		
		Assert.assertEquals(expectedUserEmail, actualUserEmail);
		
		
		Assert.assertEquals("micael.felps@gmail.com", actualUserEmail.getEmail());
		
	}*/
	
	@Test 
	public void testUserFirstNamePass() {
		
		//create an instance of the Users class
		Users user = new Users();
		
		//Specify the user first name for the object
		user.setFirstName("Micael");
		
		//Fetch the user first name from the object
		String userFirstName = user.getFirstName();
		
		
		//Verify that the retrieved value for the first name is accurate
		Assert.assertEquals("Micael", userFirstName);
	}
	
	/*@Test 
	public void testUserFirstNameFail() {
		
		//create an instance of the Users class
		Users user = new Users();
		
		//Specify the users first name for the object
		user.setFirstName("Wayne");
		
		//Fetch the users first name from the object
		String userFirstName = user.getFirstName();
		
		
		//Verify that the retrieved value for the first name is accurate and crashes
		Assert.assertEquals("Mable", userFirstName);
	}*/
	
	@Test 
	public void testUserLastNamePass() {
		
		//create an instance of the Users class
		Users user = new Users();
		
		//Specify the users last name for the object
		user.setLastName("Crumbly");
		
		//Fetch the users last name from the object
		String userLastName = user.getLastName();
		
		
		//Verify that the retrieved value for the last name is accurate
		Assert.assertEquals("Crumbly", userLastName);
	}
	
	/*@Test 
	public void testUserLastNameFail() {
		
		//create an instance of the Users class
		Users user = new Users();
		
		//Specify the employee last name for the object
		user.setLastName("Hepler");
		
		//Fetch the employee last name from the object
		String userLastName = user.getLastName();
		
		
		//Verify that the retrieved value for the last name is accurate and fails miserably
		Assert.assertEquals("Bruce", userLastName);
	}*/

}
