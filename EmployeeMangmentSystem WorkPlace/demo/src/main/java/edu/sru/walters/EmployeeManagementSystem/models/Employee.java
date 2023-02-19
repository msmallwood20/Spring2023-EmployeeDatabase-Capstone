package edu.sru.walters.EmployeeManagementSystem.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	@Nonnull
	private String firstName;
	
	@Nonnull
	private String lastName;
	
	@Nonnull
	private String email;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return email;
	}
	public void setEmailAddress(String emailAddress) {
		this.email = emailAddress;
	}
}
