package com.finanace.shreeji.bo;

public class Financer {

	private String bankName;
	private String executiveName;
	private String mobileNumber;
	private String agreementDone;

	public Financer() {
		super();
	}

	public Financer(String bankName, String executiveName, String mobileNumber, String agreementDone) {
		super();
		this.bankName = bankName;
		this.executiveName = executiveName;
		this.mobileNumber = mobileNumber;
		this.agreementDone = agreementDone;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getExecutiveName() {
		return executiveName;
	}

	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAgreementDone() {
		return agreementDone;
	}

	public void setAgreementDone(String agreementDone) {
		this.agreementDone = agreementDone;
	}

	@Override
	public String toString() {
		return "Financer [bankName=" + bankName + ", executiveName=" + executiveName + ", mobileNumber=" + mobileNumber
				+ ", agreementDone=" + agreementDone + "]";
	}

}
