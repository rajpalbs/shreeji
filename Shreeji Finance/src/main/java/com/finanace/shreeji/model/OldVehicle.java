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
@Table(name = "vehicle")
@Deprecated
public class OldVehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id")
	private int id;

	@Column(name = "number")
	private String number;

	@Column(name = "vehicle_generation_type", columnDefinition = "enum('NEW','OLD','RC_LIMIT')")
	@Enumerated(EnumType.STRING)
	private VehicleGenerationType vehicleGenerationType;

	@Column(name = "vehicle_type", columnDefinition = "enum('CAR','TRACTOR','CV','AUTO')")
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	@Column(name = "model_name")
	private String modelName;

	@Column(name = "engine_number")
	private String engineNumber;

	@Column(name = "chassis_number")
	private String chassisNumber;

	@Column(name = "mfg_year")
	private Integer mfgYear;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public VehicleGenerationType getVehicleGenerationType() {
		return vehicleGenerationType;
	}

	public void setVehicleGenerationType(VehicleGenerationType vehicleGenerationType) {
		this.vehicleGenerationType = vehicleGenerationType;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public Integer getMfgYear() {
		return mfgYear;
	}

	public void setMfgYear(Integer mfgYear) {
		this.mfgYear = mfgYear;
	}

	private enum VehicleGenerationType {
		OLD, NEW, RC_LIMIT;
	}

	private enum VehicleType {
		CAR, TRACTOR, CV, AUTO;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [id=").append(id).append(", number=").append(number).append(", vehicleGenerationType=")
				.append(vehicleGenerationType).append(", vehicleType=").append(vehicleType).append(", modelName=")
				.append(modelName).append(", engineNumber=").append(engineNumber).append(", chassisNumber=")
				.append(chassisNumber).append(", mfgYear=").append(mfgYear).append("]");
		return builder.toString();
	}

}
