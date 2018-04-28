package com.finanace.shreeji.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "insurance")
@Deprecated
public class OldInsurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insurance_id")
	private int id;

	@Column(name = "number")
	private int number;

	@OneToOne
	@JoinColumn(name = "vehicle_id")
	private OldVehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public OldVehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(OldVehicle vehicle) {
		this.vehicle = vehicle;
	}

}
