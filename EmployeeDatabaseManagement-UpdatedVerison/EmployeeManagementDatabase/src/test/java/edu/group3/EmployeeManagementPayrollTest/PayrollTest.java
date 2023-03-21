package edu.group3.EmployeeManagementPayrollTest;

import edu.group3.EmployeeManagement.models.payroll;

import org.junit.Assert;
import org.junit.Test;

public class PayrollTest {

	@Test
	public void testEmployeeTypePass() {
	
		// In this method, create an employee type and retrieves the relevant type after it has been specified.
		// After the employee type is retrieved from the object, do the following tests
		
		payroll actualPayrollType = new payroll();
		actualPayrollType.setemployeeType("Janitor");
		
		
		payroll expectedPayrollType = new payroll();
		expectedPayrollType.setemployeeType("Janitor");
		
		Assert.assertEquals(expectedPayrollType, actualPayrollType);
		
		
		Assert.assertEquals("Janitor", actualPayrollType.getemployeeType());
		
	}
	
	/*@Test
	public void testEmployeeTypeFail() {
	
		// In this method, we are doing the same as above but want this test to fail
		
		payroll actualPayrollType = new payroll();
		actualPayrollType.setemployeeType("Janitor");
		
		
		payroll expectedPayrollType = new payroll();
		expectedPayrollType.setemployeeType("Accountant");
		
		Assert.assertEquals(expectedPayrollType, actualPayrollType);
		
		
		Assert.assertEquals("Janitor", actualPayrollType.getemployeeType());
		
	}*/
	
	@Test
	public void testEmployeeSalaryPass() {
		
		//This method will test an employees salary with passing results
		
		payroll actualPayrollSalary = new payroll();
		actualPayrollSalary.setsalary(25000);
		
		payroll expectedPayrollSalary = new payroll();
		expectedPayrollSalary.setsalary(25000);
		
		Assert.assertEquals(expectedPayrollSalary, actualPayrollSalary);
		
		
	}
	
	/*@Test
	public void testEmployeeSalaryFail() {
		
		//This method will test an employees salary with fail
		
		payroll actualPayrollSalary = new payroll();
		actualPayrollSalary.setsalary(35000);
		
		payroll expectedPayrollSalary = new payroll();
		expectedPayrollSalary.setsalary(25000);
		
		Assert.assertEquals(expectedPayrollSalary, actualPayrollSalary);
		
		
	}*/
	
	
	
	

}
