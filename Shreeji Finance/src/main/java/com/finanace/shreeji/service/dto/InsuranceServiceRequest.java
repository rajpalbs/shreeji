package com.finanace.shreeji.service.dto;

import java.util.Date;

public class InsuranceServiceRequest {
	private String vehicleName;
	private String registrationNumber;
	private Integer manufacturingYear;
	private Date startDate;
	private Date expireDate;
	private String insuranceCompanyName;
	private Float value;
	private Float odPremiumAmount;
	private Integer totalPremium;

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}

	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getOdPremiumAmount() {
		return odPremiumAmount;
	}

	public void setOdPremiumAmount(Float odPremiumAmount) {
		this.odPremiumAmount = odPremiumAmount;
	}

	public Integer getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(Integer totalPremium) {
		this.totalPremium = totalPremium;
	}

}
