package com.finanace.shreeji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.model.Vehicle;
import com.finanace.shreeji.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = { "/create"}, method = RequestMethod.GET)
	public ModelAndView vehicleCreatePage() {
		ModelAndView modelAndView = new ModelAndView();
		Vehicle vehicle = new Vehicle();
		modelAndView.addObject("vehicle", vehicle);
		modelAndView.setViewName("vehicle/create");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/create"}, method = RequestMethod.POST)
	public ModelAndView vehicleCreatePage(@Valid Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		ModelAndView modelAndView = new ModelAndView();
		List<Vehicle> allVehicles = vehicleService.listAll();
		modelAndView.addObject("vehicles", allVehicles);
		modelAndView.setViewName("vehicle/listAll");
		return modelAndView;
	}
}
