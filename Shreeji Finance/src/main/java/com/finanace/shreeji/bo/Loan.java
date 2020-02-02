package com.finanace.shreeji.bo;

public class Loan {
	private String loanDate;
	private String loanNumber;
	private int loanAmount;

	public Loan() {
		super();
	}

	public Loan(String loanDate, String loanNumber, int loanAmount) {
		super();
		this.loanDate = loanDate;
		this.loanNumber = loanNumber;
		this.loanAmount = loanAmount;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	@Override
	public String toString() {
		return "Loan [loanDate=" + loanDate + ", loanNumber=" + loanNumber + ", loanAmount=" + loanAmount + "]";
	}

}
