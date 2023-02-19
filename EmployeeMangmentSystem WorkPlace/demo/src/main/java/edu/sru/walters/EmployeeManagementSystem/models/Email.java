/*package edu.sru.walters.EmployeeManagementSystem.models;

import java.io.File;

import jakarta.persistence.*;

@Entity
public class Email {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int userId; //Foreign Key
	
	private String userEmail;
	
	private String emailTo;
	
	private String emailSubject;
	
	private String emailMessage;
	
	private File emailAttachment;
	
	public Email() {
		
	}
	
	public Email(int userId, String userEmail) {
		this.userId = userId;
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public File getEmailAttachment() {
		return emailAttachment;
	}

	public void setEmailAttachment(File emailAttachment) {
		this.emailAttachment = emailAttachment;
	}
	
}
*/