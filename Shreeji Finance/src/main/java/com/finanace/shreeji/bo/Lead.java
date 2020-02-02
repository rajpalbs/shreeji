package com.finanace.shreeji.bo;

public class Lead {

	private String id;
	private String status;
	private String givenBy;
	private String inquiryDate;
	private Customer customer;
	private Vehicle vehicle;
	private Financer financer;
	private Loan loan;
	private String remark;

	public Lead() {
	}

	public Lead(String id, String status, String givenBy, String inquiryDate, Customer customer, Vehicle vehicle,
			Financer financer, Loan loan, String remark) {
		super();
		this.id = id;
		this.status = status;
		this.givenBy = givenBy;
		this.inquiryDate = inquiryDate;
		this.customer = customer;
		this.vehicle = vehicle;
		this.financer = financer;
		this.loan = loan;
		this.remark = remark;
	}

	public Lead(String id, String status, String givenBy, String inquiryDate, String customerName, String mobileNumber1,
			String mobileNumber2, String village, String taluka, String district, String financeBy,
			String financeExecutiveName, String financeExecutiveNumber, String agreementStatus, String vehicleName,
			String condition, String registrationNumber, int manufactureYear, String type, int loanAmount,
			String loanNumber, String loanDate,String remark) {

		this(id, status, givenBy, inquiryDate,
				new Customer(customerName, mobileNumber1, mobileNumber2, village, taluka, district),
				new Vehicle(vehicleName, condition, registrationNumber, manufactureYear, type),
				new Financer(financeBy, financeExecutiveName, financeExecutiveNumber, agreementStatus),
				new Loan(loanDate, loanNumber, loanAmount), remark);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	public String getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Financer getFinancer() {
		return financer;
	}

	public void setFinancer(Financer financer) {
		this.financer = financer;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Lead [id=" + id + ", status=" + status + ", givenBy=" + givenBy + ", inquiryDate=" + inquiryDate
				+ ", customer=" + customer + ", vehicle=" + vehicle + ", financer=" + financer + ", loan=" + loan
				+ ", remark=" + remark + "]";
	}

}
