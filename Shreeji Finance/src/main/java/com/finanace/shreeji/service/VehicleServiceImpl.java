package com.finanace.shreeji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.Vehicle;
import com.finanace.shreeji.repository.VehicleRepository;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository; 
	
	@Override
	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}	

	@Override
	public List<Vehicle> listAll() {
		return vehicleRepository.findAll();
	}

}
