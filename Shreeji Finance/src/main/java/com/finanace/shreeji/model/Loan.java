package com.finanace.shreeji.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_id")
	private int id;

	@Column(name = "loan_amount")
	private float loanAmount;

	@Column(name = "advance_amount")
	private float advanceAmount;

	@Column(name = "file_charge_amount")
	private float fileChargeAmount;

	@Column(name = "loan_insurance_amount")
	private float loanInsuranceAmount;

	@Column(name = "emi_amount")
	private float emiAmount;

	@Column(name = "tenure_type", columnDefinition = "enum('MONTHLY','QUATERLY','HALFYEARLY')")
	@Enumerated(EnumType.STRING)
	private TenureType tenureType;

	@Column(name = "tenure_count")
	private int tenureCount;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public float getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(float advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public float getFileChargeAmount() {
		return fileChargeAmount;
	}

	public void setFileChargeAmount(float fileChargeAmount) {
		this.fileChargeAmount = fileChargeAmount;
	}

	public float getLoanInsuranceAmount() {
		return loanInsuranceAmount;
	}

	public void setLoanInsuranceAmount(float loanInsuranceAmount) {
		this.loanInsuranceAmount = loanInsuranceAmount;
	}

	public float getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(float emiAmount) {
		this.emiAmount = emiAmount;
	}

	public TenureType getTenureType() {
		return tenureType;
	}

	public void setTenureType(TenureType tenureType) {
		this.tenureType = tenureType;
	}

	public int getTenureCount() {
		return tenureCount;
	}

	public void setTenureCount(int tenureCount) {
		this.tenureCount = tenureCount;
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

	public enum TenureType {
		MONTHLY, QUATERLY, HALFYEARLY;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Loan [id=").append(id).append(", loanAmount=").append(loanAmount).append(", advanceAmount=")
				.append(advanceAmount).append(", fileChargeAmount=").append(fileChargeAmount)
				.append(", loanInsuranceAmount=").append(loanInsuranceAmount).append(", emiAmount=").append(emiAmount)
				.append(", tenureType=").append(tenureType).append(", tenureCount=").append(tenureCount)
				.append(", customer=").append(customer).append(", vehicle=").append(vehicle).append("]");
		return builder.toString();
	}	
}
