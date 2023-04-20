package edu.group3.EmployeeManagement.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
public class Timesheets {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "payperiod_week")
	private String payperiod_week;
	
	public Timesheets()
	{
		
	}
	
	public Timesheets(String firstName, String payperiod_week) {
		this.firstName = firstName;
		this.payperiod_week = payperiod_week;
	}
	
	  	public long getId() {
		    return id;
		  }

		  public void setId(long id) {
		    this.id = id;
		  }

		  public String getFirstName() {
		    return firstName;
		  }

		  public void setgetFirstName(String firstName) {
		    this.firstName = firstName;
		  }

		  public String getpayperiod_week() {
		    return payperiod_week;
		  }

		  public void setpayperiod_week(String payperiod_week) {
		    this.payperiod_week = payperiod_week;
		  }
}

