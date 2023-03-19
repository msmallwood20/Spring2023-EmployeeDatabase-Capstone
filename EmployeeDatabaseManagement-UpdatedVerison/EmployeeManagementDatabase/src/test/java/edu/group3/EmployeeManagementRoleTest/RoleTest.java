package edu.group3.EmployeeManagementRoleTest;


import edu.group3.EmployeeManagement.models.Role;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class RoleTest {

	@Test
    public void testRoleIdValuePass() {
    	
    	// Type variable = value;
    	// ClassName variableName = new ClassName();
    	Role role = new Role();
    	
    	// To use any method on the object: objectName.methodName();
    	role.setId(8);
    	
    	long actualRoleId = role.getId();
    	
    	Assert.assertEquals(8, actualRoleId);
    	
    }
    
    /*@Test
    public void testRoleIdValueFail() {
    	
    	// Type variable = value;
    	// ClassName variableName = new ClassName();
    	Role role = new Role();
    	
    	// To use any method on the object: objectName.methodName();
    	role.setId(20);
    	
    	long actualRoleId = role.getId();
    	
    	Assert.assertEquals(10, actualRoleId);
    	
    }*/

}
