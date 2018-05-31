package com.finanace.shreeji.controller.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BaseLoanRequest {
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date inquiryDate;
	private String customerName;
	private String phoneNumber;
	private String address;
	private Float loanAmount;
	private Float commissionAmount;
	private String loanStatus;
	private String loanNumber;
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date loanDate;
	private Float loanCommissionAmount;
	private String pendingRemark;
	private String cancelRemark;

	public Date getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
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

	public String getPendingRemark() {
		return pendingRemark;
	}

	public void setPendingRemark(String pendingRemark) {
		this.pendingRemark = pendingRemark;
	}

	public String getCancelRemark() {
		return cancelRemark;
	}

	public void setCancelRemark(String cancelRemark) {
		this.cancelRemark = cancelRemark;
	}

}
