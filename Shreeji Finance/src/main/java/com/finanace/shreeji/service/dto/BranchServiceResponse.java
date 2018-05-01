package com.finanace.shreeji.service.dto;

import java.util.UUID;

public class BranchServiceResponse {
	private UUID id;
	private String name;
	private String city;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
