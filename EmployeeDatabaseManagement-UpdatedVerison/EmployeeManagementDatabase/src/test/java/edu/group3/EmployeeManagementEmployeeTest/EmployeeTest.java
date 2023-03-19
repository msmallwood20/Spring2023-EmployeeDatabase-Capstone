/**
 * JUnit testing for certain Employee cases, this does not cover EVERYTHING that could possibly be tested
 */
package edu.group3.EmployeeManagementEmployeeTest;

import org.junit.Assert;
import org.junit.Test;
import edu.group3.EmployeeManagement.models.Employee;

public class EmployeeTest {

	@Test
	public void testEmployeeEmailPass() {
	
		// In this method, create an employee email and retrieve the relevant email after it has been specified.
		// After the email is retrieved from the object, do the following tests
		
		Employee actualEmployeeEmail = new Employee();
		actualEmployeeEmail.setEmail("wayne.bruce@gmail.com");
		
		
		Employee expectedEmployeeEmail = new Employee();
		expectedEmployeeEmail.setEmail("wayne.bruce@gmail.com");
		
		Assert.assertEquals(expectedEmployeeEmail, actualEmployeeEmail);
		
		
		Assert.assertEquals("wayne.bruce@gmail.com", actualEmployeeEmail.getEmail());
		
	}
	
	/*@Test
	public void testEmployeeEmailFail() {
	
		// In this method, create an employee email and retrieve the relevant email after it has been specified.
		// After the email is retrieved from the object, do the following tests and fail
		
		Employee actualEmployeeEmail = new Employee();
		actualEmployeeEmail.setEmail("bruce.wayne@gmail.com");
		
		
		Employee expectedEmployeeEmail = new Employee();
		expectedEmployeeEmail.setEmail("wayne.bruce@gmail.com");
		
		Assert.assertEquals(expectedEmployeeEmail, actualEmployeeEmail);
		
		
		Assert.assertEquals("wayne.bruce@gmail.com", actualEmployeeEmail.getEmail());
		
	}*/
	
	@Test 
	public void testEmployeeFirstNamePass() {
		
		//create an instance of the Employee class
		Employee emp = new Employee();
		
		//Specify the employee name for the object
		emp.setFirstName("Wayne");
		
		//Fetch the employee name from the object
		String employeeFirstName = emp.getFirstName();
		
		
		//Verify that the retrieved value for the first name is accurate
		Assert.assertEquals("Wayne", employeeFirstName);
	}
	
	/*@Test 
	public void testEmployeeFirstNameFail() {
		
		//create an instance of the Employee class
		Employee emp = new Employee();
		
		//Specify the employee name for the object
		emp.setFirstName("Wayne");
		
		//Fetch the employee name from the object
		String employeeFirstName = emp.getFirstName();
		
		
		//Verify that the retrieved value for the first name is accurate and crashes
		Assert.assertEquals("Mable", employeeFirstName);
	}*/
	
	@Test 
	public void testEmployeeLastNamePass() {
		
		//create an instance of the Employee class
		Employee emp = new Employee();
		
		//Specify the employee name for the object
		emp.setLastName("Bruce");
		
		//Fetch the employee name from the object
		String employeeLastName = emp.getLastName();
		
		
		//Verify that the retrieved value for the first name is accurate
		Assert.assertEquals("Bruce", employeeLastName);
	}
	
	/*@Test 
	public void testEmployeeLastNameFail() {
		
		//create an instance of the Employee class
		Employee emp = new Employee();
		
		//Specify the employee name for the object
		emp.setFirstName("Hepler");
		
		//Fetch the employee name from the object
		String employeeLastName = emp.getLastName();
		
		
		//Verify that the retrieved value for the name is accurate and fails miserably
		Assert.assertEquals("Bruce", employeeLastName);
	}*/
	
	
    @Test
    public void testEmployeeIdValuePass() {
    	
    	// Type variable = value;
    	// ClassName variableName = new ClassName();
    	Employee emp = new Employee();
    	
    	// To use any method on the object: objectName.methodName();
    	emp.setId(20);
    	
    	long actualEmployeeId = emp.getId();
    	
    	Assert.assertEquals(20, actualEmployeeId);
    	
    }
    
    /*@Test
    public void testEmployeeIdValueFail() {
    	
    	// Type variable = value;
    	// ClassName variableName = new ClassName();
    	Employee emp = new Employee();
    	
    	// To use any method on the object: objectName.methodName();
    	emp.setId(20);
    	
    	long actualEmployeeId = emp.getId();
    	
    	Assert.assertEquals(10, actualEmployeeId);
    	
    }*/

}
