/*package edu.sru.walters.EmployeeManagementSystem.models;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccountSettings> accountSettings = new ArrayList<>();
    
    protected Account() {
    	  	
    }
    
    public Account(String name, String emailAddress) {
    	this.name = name;
    	this.emailAddress = emailAddress;
    }
 
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
    
}*/
