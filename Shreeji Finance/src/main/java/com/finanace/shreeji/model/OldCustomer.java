package com.finanace.shreeji.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Deprecated
public class OldCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "co_applicant_name")
	private String coApplicantName;

	@Column(name = "garanter_name")
	private String garanterName;

	@Column(name = "contact_no_1")
	private String contactNo1;

	@Column(name = "contact_no_2")
	private String contactNo2;

	@Column(name = "id_proof_type", columnDefinition = "enum('AADHAR','ELECTION_CARD','LICENCE','PASSPORT')")
	@Enumerated(EnumType.STRING)
	private IDProofType idProofType;

	@Column(name = "id_proof_value")
	private String idProofValue;

	@Column(name = "address_type", columnDefinition = "enum('OWN','RENTAL')")
	@Enumerated(EnumType.STRING)
	private AddressType addressType;

	@Column(name = "address")
	private String address;

	@Column(name = "occupation_type", columnDefinition = "enum('JOB','BUSINESS','AGRICULTURE')")
	@Enumerated(EnumType.STRING)
	private OccupationType occupationType;

	@Column(name = "salary_type", columnDefinition = "enum('MONTHLY','YEARLY')")
	@Enumerated(EnumType.STRING)
	private SalaryType salaryType;

	@Column(name = "net_income")
	private Float netIncome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoApplicantName() {
		return coApplicantName;
	}

	public void setCoApplicantName(String coApplicantName) {
		this.coApplicantName = coApplicantName;
	}

	public String getGaranterName() {
		return garanterName;
	}

	public void setGaranterName(String garanterName) {
		this.garanterName = garanterName;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public IDProofType getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(IDProofType idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProofValue() {
		return idProofValue;
	}

	public void setIdProofValue(String idProofValue) {
		this.idProofValue = idProofValue;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public OccupationType getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(OccupationType occupationType) {
		this.occupationType = occupationType;
	}

	public SalaryType getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(SalaryType salaryType) {
		this.salaryType = salaryType;
	}

	public Float getNetIncome() {
		return netIncome;
	}

	public void setNetIncome(Float netIncome) {
		this.netIncome = netIncome;
	}

	private enum IDProofType {
		AADHAR, ELECTION_CARD, LICENCE, PASSPORT;
	}

	private enum AddressType {
		OWN, RENTAL;
	}

	private enum OccupationType {
		JOB, BUSINESS, AGRICULTURE;
	}

	private enum SalaryType {
		MONTHLY, YEARLY;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=").append(id).append(", name=").append(name).append(", coApplicantName=")
				.append(coApplicantName).append(", garanterName=").append(garanterName).append(", contactNo1=")
				.append(contactNo1).append(", contactNo2=").append(contactNo2).append(", idProofType=")
				.append(idProofType).append(", idProofValue=").append(idProofValue).append(", addressType=")
				.append(addressType).append(", address=").append(address).append(", occupationType=")
				.append(occupationType).append(", salaryType=").append(salaryType).append(", netIncome=")
				.append(netIncome).append("]");
		return builder.toString();
	}

}
