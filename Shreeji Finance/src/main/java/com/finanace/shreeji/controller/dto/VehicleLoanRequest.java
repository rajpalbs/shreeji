package com.finanace.shreeji.controller.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class VehicleLoanRequest {
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private Date inqueryDate;
	private String customerName;
	private String phoneNumber;
	private String address;
	private String vehicleName;
	private String vehiclecondition;
	private Integer manufacturingYear;
	private String financerName;
	private Float loanAmount;
	private Float commissionAmount;
	private String loanStatus;
	private String loanNumber;
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private Date loanDate;
	private Float loanCommissionAmount;

	public Date getInqueryDate() {
		return inqueryDate;
	}

	public void setInqueryDate(Date inqueryDate) {
		this.inqueryDate = inqueryDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehiclecondition() {
		return vehiclecondition;
	}

	public void setVehiclecondition(String vehiclecondition) {
		this.vehiclecondition = vehiclecondition;
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

	public Float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Float getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(Float commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Float getLoanCommissionAmount() {
		return loanCommissionAmount;
	}

	public void setLoanCommissionAmount(Float loanCommissionAmount) {
		this.loanCommissionAmount = loanCommissionAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleLoanRequest [inqueryDate=").append(inqueryDate).append(", customerName=")
				.append(customerName).append(", phoneNumber=").append(phoneNumber).append(", address=").append(address)
				.append(", vehicleName=").append(vehicleName).append(", vehiclecondition=").append(vehiclecondition)
				.append(", manufacturingYear=").append(manufacturingYear).append(", financerName=").append(financerName)
				.append(", loanAmount=").append(loanAmount).append(", commissionAmount=").append(commissionAmount)
				.append(", loanStatus=").append(loanStatus).append(", loanNumber=").append(loanNumber)
				.append(", loanDate=").append(loanDate).append(", loanCommissionAmount=").append(loanCommissionAmount)
				.append("]");
		return builder.toString();
	}

}
