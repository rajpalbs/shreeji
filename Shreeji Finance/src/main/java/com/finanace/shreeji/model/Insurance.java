package com.finanace.shreeji.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "master_insurance")
public class Insurance {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "uuid-char")
	@Column(name = "id", unique = true)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@Type(type = "uuid-char")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	@Type(type = "uuid-char")
	private Branch branch;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	@Type(type = "uuid-char")
	private Employee employee;

	@Column(name = "vehicle_name")
	private String vehicleName;

	@Column(name = "vehicle_registration_number")
	private String registrationNumber;

	@Column(name = "vehicle_manufacturing_year")
	private Integer manufacturingYear;

	@Column(name = "insurance_start_date")
	private Date startDate;

	@Column(name = "insurance_end_date")
	private Date expireDate;

	@Column(name = "insurance_company_name")
	private String insuranceCompanyName;

	@Column(name = "value")
	private Float value;

	@Column(name = "od_premium_amount")
	private Float odPremiumAmount;

	@Column(name = "total_premium")
	private Integer totalPremium;

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
