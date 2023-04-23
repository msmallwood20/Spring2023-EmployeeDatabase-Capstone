package edu.group3.EmployeeManagement.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
		
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private String fullName;

    private String username;
	
	private String email;
	
	private String password;
	
	private String oldPassword;
	
	private String newPassword;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinTable(
       name="user_role",
       joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
       inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	 
	 private Set<Role> roles = new HashSet<>();
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinTable(
       name="user_sheet",
       joinColumns={@JoinColumn(name="USER_USERNAME", referencedColumnName="username")},
       inverseJoinColumns={@JoinColumn(name="SHEET_USERNAME", referencedColumnName="username")})
	 List<Timesheets> timesheets = new ArrayList<>();
	 
	 public List<Timesheets> geTimesheets()
	 {
		 return timesheets;
	 }
	 
	 public void setTimesheets(List<Timesheets> timesheets)
	 {
		 this.timesheets = timesheets;
	 }
	 
	 public void addRole(Role role) {
		    Optional<Role> existingRole = roles.stream()
		            .filter(r -> r.getId() == role.getId())
		            .findFirst();
		    if (existingRole.isPresent()) {
		        roles.remove(existingRole.get());
		    }
		    roles.add(role);
		}
	 
		/*
		 * public void addRole(Role role) { this.roles.add(role); }
		 */
	
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
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName)
	{
		this.fullName = this.getFirstName() + " " + this.getLastName();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 public String getOldPassword() {
	        return oldPassword;
	    }

	    public void setOldPassword(String oldPassword) {
	        this.oldPassword = oldPassword;
	    }

	    public String getNewPassword() {
	        return newPassword;
	    }

	    public void setNewPassword(String newPassword) {
	        this.newPassword = newPassword;
	    }
}
