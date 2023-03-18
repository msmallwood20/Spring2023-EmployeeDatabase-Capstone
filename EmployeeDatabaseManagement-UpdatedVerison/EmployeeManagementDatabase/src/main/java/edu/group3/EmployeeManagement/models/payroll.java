package edu.group3.EmployeeManagement.models;

import jakarta.persistence.*;

@Entity
@Table(name = "payroll")
public class payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 25)
	private String employeeType;
	
	@Column(nullable = false, length = 15)
	private int salary;
	
	@Column(nullable = false, length = 30)
	private String department;
	
	@Column(nullable = false, length = 50)
	private String jobTitle;
	
	@Column(nullable = false, length = 60)
	private String firstName;
	
	@Column(nullable = false, length = 60)
	private String lastName;
	
	public String getfirstName() {
		return firstName;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getemployeeType() {
		return employeeType;
	}

	public void setemployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	
	public int getsalary() {
		return salary;
	}

	public void setsalary(int salary) {
		this.salary = salary;
	}
	
	public String getdepartment() {
		return department;
	}

	public void setdepartment(String department) {
		this.department = department;
	}
		
	public String getjobTitle() {
		return jobTitle;
	}

	public void setjobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
}
