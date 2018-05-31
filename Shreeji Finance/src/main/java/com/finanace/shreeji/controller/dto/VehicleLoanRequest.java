package com.finanace.shreeji.controller.dto;

public class VehicleLoanRequest extends BaseLoanRequest {
	private String vehicleName;
	private String vehicleCondition;
	private Integer manufacturingYear;
	private String financerName;

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleCondition() {
		return vehicleCondition;
	}

	public void setVehicleCondition(String vehicleCondition) {
		this.vehicleCondition = vehicleCondition;
	}

	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public String getFinancerName() {
		return financerName;
	}

	public void setFinancerName(String financerName) {
		this.financerName = financerName;
	}

	@Override
	public String toString() {
		return "VehicleLoanRequest [vehicleName=" + vehicleName + ", vehicleCondition=" + vehicleCondition
				+ ", manufacturingYear=" + manufacturingYear + ", financerName=" + financerName + ", getInquiryDate()="
				+ getInquiryDate() + ", getCustomerName()=" + getCustomerName() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getAddress()=" + getAddress() + ", getLoanAmount()=" + getLoanAmount()
				+ ", getCommissionAmount()=" + getCommissionAmount() + ", getLoanStatus()=" + getLoanStatus()
				+ ", getLoanNumber()=" + getLoanNumber() + ", getLoanDate()=" + getLoanDate()
				+ ", getLoanCommissionAmount()=" + getLoanCommissionAmount() + ", getPendingRemark()="
				+ getPendingRemark() + ", getCancelRemark()=" + getCancelRemark() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}