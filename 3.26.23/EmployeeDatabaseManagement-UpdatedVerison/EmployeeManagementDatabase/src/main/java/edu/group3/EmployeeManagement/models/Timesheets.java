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
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "type")
	private String type;
	
	public Timesheets()
	{
		
	}
	
	public Timesheets(String title, String description, String type) {
		this.title = title;
		this.description = description;
		this.type = type;
	}
	
	  	public long getId() {
		    return id;
		  }

		  public void setId(long id) {
		    this.id = id;
		  }

		  public String getTitle() {
		    return title;
		  }

		  public void setTitle(String title) {
		    this.title = title;
		  }

		  public String getDescription() {
		    return description;
		  }

		  public void setDescription(String description) {
		    this.description = description;
		  }

		  public String getType() {
			  return description;
		  }

		 public void setType(String type) {
			 this.type = ".xlsx";
		}

		  @Override
		  public String toString() {
		    return "TimeSheet [id=" + id + ", title=" + title + ", desc=" + description + ", type=" + type + "]";
		  }
	
	
	
}

