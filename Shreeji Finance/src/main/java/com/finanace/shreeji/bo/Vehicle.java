package com.finanace.shreeji.bo;

public class Vehicle {

	private String name;
	private String condition;
	private String registrationNumber;
	private int manufactureYear;
	private String type;

	public Vehicle() {
	}

	public Vehicle(String name, String condition, String registrationNumber, int manufactureYear, String type) {
		super();
		this.name = name;
		this.condition = condition;
		this.registrationNumber = registrationNumber;
		this.manufactureYear = manufactureYear;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", condition=" + condition + ", registrationNumber=" + registrationNumber
				+ ", manufactureYear=" + manufactureYear + ", type=" + type + "]";
	}

}
