package com.finanace.shreeji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.model.Vehicle;

@Repository("vehicleRepository")
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
