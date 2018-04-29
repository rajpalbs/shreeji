package com.finanace.shreeji.controller.dto;

import java.util.UUID;

public class EmployeeRegistrationRequest {

	private String name;
	private String surname;
	private String email;
	private String password;
	private UUID branch;

	public EmployeeRegistrationRequest() {
	}

	public EmployeeRegistrationRequest(String name, String surname, String email, String password, UUID branch) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.branch = branch;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeRegistrationRequest [name=").append(name).append(", surname=").append(surname)
				.append(", email=").append(email).append(", password=").append(password).append(", branch=")
				.append(branch).append("]");
		return builder.toString();
	}

}
