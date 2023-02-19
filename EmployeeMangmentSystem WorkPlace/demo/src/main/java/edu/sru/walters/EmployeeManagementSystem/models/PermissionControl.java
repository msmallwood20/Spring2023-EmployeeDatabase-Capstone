/*package edu.sru.walters.EmployeeManagementSystem.models;

import jakarta.persistence.*;

@Entity
public class PermissionControl {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int userId; //Foreign Key!!
	
	private String departmentType;
	
	private Boolean editUser;
	
	private Boolean createUser;
	
	private Boolean deleteUser;
	
	public PermissionControl() {
		
	}
	
	public PermissionControl(String departmentType, Boolean editUser, Boolean createUser, Boolean deleteUser){
		super();
		this.departmentType = departmentType;
		this.editUser = editUser;
		this.createUser = createUser;
		this.deleteUser = deleteUser;
		
	}

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public Boolean getEditUser() {
		return editUser;
	}

	public void setEditUser(Boolean editUser) {
		this.editUser = editUser;
	}

	public Boolean getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Boolean createUser) {
		this.createUser = createUser;
	}

	public Boolean getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(Boolean deleteUser) {
		this.deleteUser = deleteUser;
	}
	
	
}
*/