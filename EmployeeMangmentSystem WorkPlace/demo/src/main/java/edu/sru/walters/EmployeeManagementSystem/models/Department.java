/*package edu.sru.walters.EmployeeManagementSystem.models;

import jakarta.persistence.*;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int userId; //Foreign Key!!
	
	private String departmentType;
	
	private String admin;
	
	private String nonAdmin;
	
	public Department() {
			
	}
	
	public Department(String departmentType, String admin, String nonAdmin) {
		super();
		this.departmentType = departmentType;
		this.admin = admin;
		this.nonAdmin = nonAdmin;	
	}
	
	public int getId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public String getDepartmentType(){
		return departmentType;
	}
	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getNonAdmin() {
		return nonAdmin;
	}
	public void setNonAdmin(String nonAdmin) {
		this.nonAdmin = nonAdmin;
	}
}*/