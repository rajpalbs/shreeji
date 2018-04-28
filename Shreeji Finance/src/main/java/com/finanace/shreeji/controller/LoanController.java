package com.finanace.shreeji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.model.OldCustomer;
import com.finanace.shreeji.model.OldLoan;
import com.finanace.shreeji.model.OldVehicle;
import com.finanace.shreeji.service.CustomerService;
import com.finanace.shreeji.service.LoanService;
import com.finanace.shreeji.service.VehicleService;

@Controller
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LoanService loanService;

	//TODO : create loan service which fetch vehicle service and customer service
	@RequestMapping(value = { "/createinit"}, method = RequestMethod.GET)
	public ModelAndView loanCreatePage() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<OldCustomer> allCustomer = customerService.listAll();
		
		modelAndView.addObject("customers", allCustomer);
		List<OldVehicle> allVehicles = vehicleService.listAll();
		modelAndView.addObject("vehicles", allVehicles);
		modelAndView.addObject("loan",new OldLoan());
		modelAndView.setViewName("loan/create");
		return modelAndView;
	}

	@RequestMapping(value = { "/createinit"}, method = RequestMethod.POST)
	public ModelAndView loanCreatePage(@Valid OldLoan loan) {
		ModelAndView modelAndView = new ModelAndView();
		loanService.saveLoan(loan);
		List<OldLoan> loans = loanService.listAll();
		System.out.println(loans);
		modelAndView.addObject("loans", loans);
		modelAndView.setViewName("loan/listAllPendingLoan");
		return modelAndView;
	}

	
	@RequestMapping(value = { "/createfinal"}, method = RequestMethod.GET)
	public ModelAndView finalizePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/finalize");
		return modelAndView;
	}
}
