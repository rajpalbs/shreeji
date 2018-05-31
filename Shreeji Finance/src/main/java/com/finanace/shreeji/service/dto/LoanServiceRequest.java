package com.finanace.shreeji.service.dto;

import java.util.Date;

import com.finanace.shreeji.type.LoanStatusType;
import com.finanace.shreeji.type.LoanType;

public class LoanServiceRequest {
	private Date inquiryDate;
	private LoanType loanType;
	private LoanStatusType loanStatus;
	private Float loanAmount;
	private Float commissionAmount;
	private String loanNumber;
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

	public LoanStatusType getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatusType loanStatus) {
		this.loanStatus = loanStatus;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public LoanStatusType getLoanStatusType() {
		return loanStatus;
	}

	public void setLoanStatusType(LoanStatusType loanStatusType) {
		this.loanStatus = loanStatusType;
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
