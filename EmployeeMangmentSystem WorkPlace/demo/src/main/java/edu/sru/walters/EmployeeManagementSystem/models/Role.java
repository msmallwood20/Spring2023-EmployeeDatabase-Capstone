package edu.sru.walters.EmployeeManagementSystem.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Nonnull
	private String name;
	
	public Role() {
		
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
