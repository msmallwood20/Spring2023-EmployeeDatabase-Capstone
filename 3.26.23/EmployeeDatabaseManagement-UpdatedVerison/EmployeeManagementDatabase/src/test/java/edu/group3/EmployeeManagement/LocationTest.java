package edu.group3.EmployeeManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.group3.EmployeeManagement.models.Location;

class LocationTest {

	@Test
	public void testLocationDescription() {
		
		//Description testing 
		
		Location actualLocationDescription = new Location();
		actualLocationDescription.setDescription("New York City");
		
		
		Location expectedLocationDescription = new Location();
		expectedLocationDescription.setDescription("New York City");
		
		Assert.assertEquals(expectedLocationDescription, actualLocationDescription);
		
		
		Assert.assertEquals("New York City", actualLocationDescription.getDescription());
		
	}
	
	@Test
	public void testLocationDetails() {
		
		//Details testing 
		
		Location actualLocationDetails = new Location();
		actualLocationDetails.setDetails("Crowded");
		
		
		Location expectedLocationDetails = new Location();
		expectedLocationDetails.setDetails("Crowded");
		
		Assert.assertEquals(expectedLocationDetails, actualLocationDetails);
		
		
		Assert.assertEquals("Crowded", actualLocationDetails.getDetails());
		
	}

}
