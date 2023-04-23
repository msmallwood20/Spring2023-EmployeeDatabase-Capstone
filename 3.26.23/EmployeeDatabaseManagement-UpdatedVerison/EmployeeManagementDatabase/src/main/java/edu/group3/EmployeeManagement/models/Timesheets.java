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
import jakarta.persistence.ManyToOne;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "payperiodWeek")
	private String payperiodWeek;
	
	@Column(name = "hourlyWage")
	private String hourlyWage;
	
	@Column(name = "hoursWorked")
	private String hoursWorked;
	
	@Column(name = "monthPay")
	private String monthPay;
	
	@Column(name = "startTime")
	private String startTime;
	
	@Column(name = "endTime")
	private String endTime;
	
	public Timesheets()
	{
		
	}
	
	public Timesheets(String firstName, String lastName, String username, String payperiodWeek, String hourlyWage, String hoursWorked, String monthPay, String endTime, String startTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.payperiodWeek = payperiodWeek;
		this.hourlyWage = hourlyWage;
		this.hoursWorked = hoursWorked;
		this.monthPay = monthPay;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	  	public long getId() {
		    return id;
		  }

		  public void setId(long id) {
		    this.id = id;
		  }

		  public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
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

		  public String getPayperiodWeek() {
		    return payperiodWeek;
		  }

		  public void setPayperiodWeek(String payperiodWeek) {
		    this.payperiodWeek = payperiodWeek;
		  }
		  
		  public String getHourlyWage() {
			    return hourlyWage;
			  }

		  public void setHourlyWage(String hourlyWage) {
			    this.hourlyWage = hourlyWage;
			  }
		  public String getHoursWorked() {
			    return hoursWorked;
			  }

		  public void setHoursWorked(String hoursWorked) {
			    this.hoursWorked = hoursWorked;
			  }
		  public String getMonthPay() {
			    return monthPay;
			  }

		  public void setMonthPay(String monthPay) {
			    this.monthPay = monthPay;
			  }
		  
		  public String getStartTime() {
			    return startTime;
			  }

		  public void setStartTime(String startTime) {
			    this.startTime = startTime;
			  }
		  
		  public String getEndTime() {
			    return endTime;
			  }

		  public void setEndTime(String endTime) {
			    this.endTime = endTime;
			  }
}

