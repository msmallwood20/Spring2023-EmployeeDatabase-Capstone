package edu.sru.walters.EmployeeManagementSystem.models;


import java.sql.Date;
import java.util.Collection;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;



@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	@Nonnull
	private String firstName;
	
	@Nonnull
	private String lastName;
	
	private String password;
	
	private String email;
	
	@Nonnull
	private String phoneNumber;
	
	
	private String streetAddress;
	
	
	private String city;
	
	
	private String state;
	
	
	private String zipCode;
	
	
	private String department;
	
	
	private String payRate;
	
	
	private int employeeType;
	
	
	private Date dateEmployed;
	
	
	private Date dateUnemployed;
	
	private Collection<Role> roles;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailAddress() {
		return email;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.email = emailAddress;
	}
	
	public String getPhobeNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPayRate() {
		return payRate;
	}
	
	public void setPayRate(String payRate) {
		this.payRate = payRate;
	}
	public int getEmployeeType() {
		return employeeType;
	}
	
	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}
	public Date getDateEmployed() {
		return dateEmployed;
	}
	
	public void setDateEmployed(Date dateEmployed) {
		this.dateEmployed = dateEmployed;
	}
	public Date getDateUnemployed() {
		return dateUnemployed;
	}
	
	public void setDateUnemployed(Date dateUnemployed) {
		this.dateUnemployed = dateUnemployed;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
