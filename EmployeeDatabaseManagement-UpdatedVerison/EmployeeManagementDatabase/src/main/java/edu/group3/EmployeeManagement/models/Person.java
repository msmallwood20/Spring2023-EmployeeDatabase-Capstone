package edu.group3.EmployeeManagement.models;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String otherName;
	
	private String title;
	
	private String initials;
	
	private String socialSecurityNumber;
	
	private String gender;
	
	private String maritalStatus;
	
	@ManyToOne
	@JoinColumn(name="countryId", insertable=false, updatable=false)
	private Country country;
	
	private Integer countryId;
	
	@ManyToOne
	@JoinColumn(name="stateId", insertable=false, updatable=false)
	private State state;
	
	private Integer stateId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	private String city;
	
	private String address;
	
	private String phone;
	
	private String mobile;
	
	private String email;
	
	private String photo;
}
