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
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "payperiod_week")
	private String payperiod_week;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "Day_1_Start")
	private Integer day_1_start;
	
	@Column(name = "Day_1_LunchS")
	private Integer day_1_lunchstart;
	
	@Column(name = "Day_1_LunchE")
	private Integer day_1_lunchend;
	
	@Column(name = "Day_1_End")
	private Integer day_1_end;
	
	@Column(name = "Day_1_Total")
	private Integer day_1_total;
	
	
	public Timesheets()
	{
		
	}
	
	public Timesheets(String username, String payperiod_week, String type, Integer day_1_start, Integer day_1_lunchstart, Integer day_1_lunchend) {
		this.username = username;
		this.payperiod_week = payperiod_week;
		this.type = type;
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

		  public String getpayperiod_week() {
		    return payperiod_week;
		  }

		  public void setpayperiod_week1(String payperiod_week) {
		    this.payperiod_week = payperiod_week;
		  }

		  public String getType() {
			  return payperiod_week;
		  }

		 public void setType(String type) {
			 this.type = ".xlsx";
		}

		  @Override
		  public String toString() {
		    return "TimeSheet [id=" + id + ", username=" + username + ", payperiod_week1=" + payperiod_week + ", type=" + type + "]";
		  }
	
	
	
}

