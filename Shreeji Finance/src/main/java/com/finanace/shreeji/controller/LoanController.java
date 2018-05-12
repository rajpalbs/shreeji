package com.finanace.shreeji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.controller.dto.VehicleLoanRequest;

@Controller
@RequestMapping("/loan/*")
public class LoanController {
	
	@RequestMapping(value = "/vehicle/create", method = RequestMethod.GET)
	public ModelAndView showCreateLoanPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/loan/vehicleloan");
		return modelAndView;
	}
	
	@RequestMapping(value = "/vehicle/create", method = RequestMethod.POST)
	public ModelAndView createLoan(VehicleLoanRequest vehicleLoanRequest){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/loan/vehicleloan");
		return modelAndView;
	}
}
