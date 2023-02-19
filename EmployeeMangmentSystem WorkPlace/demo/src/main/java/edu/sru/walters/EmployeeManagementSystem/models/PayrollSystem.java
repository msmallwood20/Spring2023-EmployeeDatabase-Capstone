/*package edu.sru.walters.EmployeeManagementSystem.models;

import jakarta.persistence.*;

@Entity
public class PayrollSystem {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int payrollId;
	
	private int userID; //Foreign Key
	
	private int payRate;
	
	private Boolean directDeposit;
	
	private Boolean mailCheck;
	
	private int presentCount;
	
	private int absentCount;
	
	private int lateCount;
	
	public PayrollSystem() {
		
	}
	
	public PayrollSystem(int userId, int payRate){
		this.userID = userId;
		this.payRate = payRate;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getPayRate() {
		return payRate;
	}

	public void setPayRate(int payRate) {
		this.payRate = payRate;
	}

	public Boolean getDirectDeposit() {
		return directDeposit;
	}

	public void setDirectDeposit(Boolean directDeposit) {
		this.directDeposit = directDeposit;
	}

	public Boolean getMailCheck() {
		return mailCheck;
	}

	public void setMailCheck(Boolean mailCheck) {
		this.mailCheck = mailCheck;
	}

	public int getPresentCount() {
		return presentCount;
	}

	public void setPresentCount(int presentCount) {
		this.presentCount = presentCount;
	}

	public int getAbsentCount() {
		return absentCount;
	}

	public void setAbsentCount(int absentCount) {
		this.absentCount = absentCount;
	}

	public int getLateCount() {
		return lateCount;
	}

	public void setLateCount(int lateCount) {
		this.lateCount = lateCount;
	}

}
*/