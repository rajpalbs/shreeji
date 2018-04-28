package com.finanace.shreeji.service;

import java.util.List;

import com.finanace.shreeji.model.OldVehicle;

public interface VehicleService {
	public void saveVehicle(OldVehicle vehicle);
	public List<OldVehicle> listAll();
}
