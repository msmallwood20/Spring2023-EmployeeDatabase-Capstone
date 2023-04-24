package edu.group3.EmployeeManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.group3.EmployeeManagement.models.State;

class StateModelTest {

	@Test
	public void testStateCapital() {
		
		//Testing for correct state capital
		
		State actualStateCapital = new State();
		actualStateCapital.setCapital("Harrisburg");
		
		
		State expectedStateCapital = new State();
		expectedStateCapital.setCapital("Harrisburg");
		
		Assert.assertEquals(expectedStateCapital, actualStateCapital);
		
		
		Assert.assertEquals("Harrisburg", actualStateCapital.getCapital());
		
	}
	
	@Test
	public void testStateName() {
		
		//Test for verifying state name 
		
		State state = new State();
		state.setName("North Dakota");
		
		Assert.assertEquals("North Dakota", state.getName());	
	
	}
	
	
    @Test
    public void testStateIdValue() {
    	
    	//State ID test
    	
    	State state = new State();
    	
    	
    	state.setId(21);
    	
    	int actualStateId = state.getId();
    	
    	Assert.assertEquals(21, actualStateId);
    	
    }
    
    @Test
    public void testStateCode() {

    	//Zipcode test
    	
    	State state = new State();
    	
    	
    	state.setCode("16002");
    	
    	String actualStateCode = state.getCode();
    	
    	Assert.assertEquals("16002", actualStateCode);
    	
    	
    }

}
