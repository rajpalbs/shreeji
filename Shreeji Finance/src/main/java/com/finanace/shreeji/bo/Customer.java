package com.finanace.shreeji.bo;

public class Customer {

	private String name;
	private String mobileNumber1;
	private String mobileNumber2;
	private String village;
	private String taluka;
	private String district;

	public Customer() {
		super();
	}

	public Customer(String name, String mobileNumber1, String mobileNumber2, String village, String taluka,
			String district) {
		super();
		this.name = name;
		this.mobileNumber1 = mobileNumber1;
		this.mobileNumber2 = mobileNumber2;
		this.village = village;
		this.taluka = taluka;
		this.district = district;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber1() {
		return mobileNumber1;
	}

	public void setMobileNumber1(String mobileNumber1) {
		this.mobileNumber1 = mobileNumber1;
	}

	public String getMobileNumber2() {
		return mobileNumber2;
	}

	public void setMobileNumber2(String mobileNumber2) {
		this.mobileNumber2 = mobileNumber2;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNumber1=" + mobileNumber1 + ", mobileNumber2=" + mobileNumber2
				+ ", village=" + village + ", taluka=" + taluka + ", district=" + district + "]";
	}

}
