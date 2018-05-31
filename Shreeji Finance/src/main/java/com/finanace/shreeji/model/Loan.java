package com.finanace.shreeji.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.finanace.shreeji.type.LoanStatusType;
import com.finanace.shreeji.type.LoanType;

@Entity
@Table(name = "master_loan")
public class Loan {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "uuid-char")
	@Column(name = "id", unique = true)
	private UUID id;

	@Column(name = "loan_type", columnDefinition = "enum('VEHICLE','HOME','KCC')")
	@Enumerated(EnumType.STRING)
	private LoanType loanType;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@Type(type = "uuid-char")
	private Customer customer;

	@Column(name = "inquiry_Date")
	private Date inquiryDate;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	@Type(type = "uuid-char")
	private Branch branch;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	@Type(type = "uuid-char")
	private Employee employee;

	@Column(name = "status", columnDefinition = "enum('PASS','PENDING','CANCELLED')")
	@Enumerated(EnumType.STRING)
	private LoanStatusType loanStatus;

	@Column(name = "loan_amount")
	private Float loanAmount;

	@Column(name = "commission_amount")
	private Float commissionAmount;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public Date getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LoanStatusType getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatusType loanStatus) {
		this.loanStatus = loanStatus;
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

}
