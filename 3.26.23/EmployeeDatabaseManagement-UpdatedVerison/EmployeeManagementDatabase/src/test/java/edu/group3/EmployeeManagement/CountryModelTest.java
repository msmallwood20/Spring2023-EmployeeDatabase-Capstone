package edu.group3.EmployeeManagement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.group3.EmployeeManagement.models.Country;

class CountryModelTest {

	@Test
	public void testCapital() {
		
		//Testing for correct country capital
		
		Country actualCountry = new Country();
		actualCountry.setCapital("Washington D.C.");
		
		
		Country expectedCountry = new Country();
		expectedCountry.setCapital("Washington D.C.");
		
		Assert.assertEquals(expectedCountry, actualCountry);
		
		
		Assert.assertEquals("Washington D.C.", actualCountry.getCapital());
		
	}
	
	@Test
	public void testCountryContinent() {
		
		//Test for verifying country continent 
		
		Country country = new Country();
		country.setContinent("North America");
		
		Assert.assertEquals("North America", country.getContinent());	
	
	}
	
	
    @Test
    public void testCountryIdValue() {
    	
    	//Country ID test
    	
    	Country country = new Country();
    	
    	
    	country.setId(21);
    	
    	int actualCountryId = country.getId();
    	
    	Assert.assertEquals(21, actualCountryId);
    	
    }
    
    @Test
    public void testCountryNationality() {

    	//Nationality test
    	
    	Country country = new Country();
    	
    	
    	country.setNationality("Brazilian");
    	
    	String actualCountryNationality = country.getNationality();
    	
    	Assert.assertEquals("Brazilian", actualCountryNationality);
    	
    	
    }

}
