package com.finanace.shreeji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.controller.dto.InsuranceRequest;

@Controller
@RequestMapping("/insurance/*")
public class InsuranceController {

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showInsuranceLandingPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/insurance/insurance");
		return modelAndView;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createInsurance(InsuranceRequest insuranceRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/insurance/insurance");
		return modelAndView;
	}

}
