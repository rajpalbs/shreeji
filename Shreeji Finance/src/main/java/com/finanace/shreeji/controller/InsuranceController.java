package com.finanace.shreeji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {
	@RequestMapping(value = { "/create"}, method = RequestMethod.GET)
	public ModelAndView insuranceCreatePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("insurance/create");
		return modelAndView;
	}
}
