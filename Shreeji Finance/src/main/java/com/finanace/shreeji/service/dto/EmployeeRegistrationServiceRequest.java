package com.finanace.shreeji.service.dto;

import java.util.UUID;

import com.finanace.shreeji.type.EmployeeStatusType;
import com.finanace.shreeji.type.RoleType;

public class EmployeeRegistrationServiceRequest {
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private UUID branch;
	private RoleType roleType;
	private EmployeeStatusType employeeStatusType;

	public EmployeeRegistrationServiceRequest(){}
	
	public EmployeeRegistrationServiceRequest(String name, String surname, String email, String password, UUID branch,
			RoleType roleType, EmployeeStatusType employeeStatusType) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.branch = branch;
		this.roleType = roleType;
		this.employeeStatusType = employeeStatusType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public UUID getBranch() {
		return branch;
	}

	public void setBranch(UUID branch) {
		this.branch = branch;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public EmployeeStatusType getEmployeeStatusType() {
		return employeeStatusType;
	}

	public void setEmployeeStatusType(EmployeeStatusType employeeStatusType) {
		this.employeeStatusType = employeeStatusType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeRegistrationServiceRequest [name=").append(name).append(", surname=").append(surname)
				.append(", email=").append(email).append(", password=").append(password).append(", branch=")
				.append(branch).append(", roleType=").append(roleType).append(", employeeStatusType=")
				.append(employeeStatusType).append("]");
		return builder.toString();
	}
}
