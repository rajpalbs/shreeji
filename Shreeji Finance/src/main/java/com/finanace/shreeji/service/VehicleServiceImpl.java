package com.finanace.shreeji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.OldVehicle;
import com.finanace.shreeji.repository.VehicleRepository;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository; 
	
	@Override
	public void saveVehicle(OldVehicle vehicle) {
		vehicleRepository.save(vehicle);
	}	

	@Override
	public List<OldVehicle> listAll() {
		return vehicleRepository.findAll();
	}

}
