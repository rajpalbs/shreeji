package com.finanace.shreeji.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.controller.dto.InsuranceRequest;
import com.finanace.shreeji.service.InsuranceService;
import com.finanace.shreeji.service.dto.CustomerServiceRequest;
import com.finanace.shreeji.service.dto.InsuranceServiceRequest;

@Controller
@RequestMapping("/insurance/*")
public class InsuranceController {
	
	@Autowired
	private InsuranceService insuranceService; 

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showInsuranceLandingPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/insurance/insurance");
		return modelAndView;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createInsurance(InsuranceRequest insuranceRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Insurance Data saved successfully with below details !!!");
		InsuranceServiceRequest insuranceServiceRequest = new InsuranceServiceRequest();
		BeanUtils.copyProperties(insuranceRequest,insuranceServiceRequest);
		
		CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();
		customerServiceRequest.setName(insuranceRequest.getCustomerName());
		BeanUtils.copyProperties(insuranceRequest, customerServiceRequest);
		customerServiceRequest.setContactNumber(insuranceRequest.getPhoneNumber());

		
		insuranceService.storeInsuranceDetails(insuranceServiceRequest,customerServiceRequest);
		Map<String, String> data = new LinkedHashMap<>();
		setData(insuranceRequest, data);
		modelAndView.addObject("data",data);
		modelAndView.setViewName("/admin/home");
		return modelAndView;
	}
	
	private void setData(InsuranceRequest insuranceRequest,Map<String, String> data){
		data.put("Customer Name", insuranceRequest.getCustomerName());
		data.put("Vehicle Name", insuranceRequest.getVehicleName());
		data.put("Registraion Number", insuranceRequest.getRegistrationNumber());
		data.put("Insurance Start Date",new SimpleDateFormat("dd-MMM-yyyy").format(insuranceRequest.getStartDate()));
		data.put("Insurance End Date",new SimpleDateFormat("dd-MMM-yyyy").format(insuranceRequest.getExpireDate()));
		data.put("Insurance Company Name", insuranceRequest.getInsuranceCompanyName());
		data.put("Value", insuranceRequest.getValue().toString());
		data.put("OD Premium Amoaunt", insuranceRequest.getOdPremiumAmount().toString());
		data.put("Total Premium", insuranceRequest.getTotalPremium().toString());
	}
}
