package edu.group3.EmployeeManagement.models;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	public Role()
	{
		
	}
	
	public Role(String name) {
		this.name = name;
	}

	public Role(Integer id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public Role(Integer id)
	{
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
