package com.finanace.shreeji.service;

import java.util.List;

import com.finanace.shreeji.model.Vehicle;

public interface VehicleService {
	public void saveVehicle(Vehicle vehicle);
	public List<Vehicle> listAll();
}
