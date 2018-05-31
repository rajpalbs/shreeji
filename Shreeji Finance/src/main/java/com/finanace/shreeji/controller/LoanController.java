package com.finanace.shreeji.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.controller.dto.BaseLoanRequest;
import com.finanace.shreeji.controller.dto.VehicleLoanRequest;
import com.finanace.shreeji.service.LoanService;
import com.finanace.shreeji.service.dto.CustomerServiceRequest;
import com.finanace.shreeji.service.dto.LoanServiceRequest;
import com.finanace.shreeji.service.dto.VehicleLoanServiceRequest;
import com.finanace.shreeji.type.LoanStatusType;
import com.finanace.shreeji.type.LoanType;

@Controller
@RequestMapping("/loan/*")
public class LoanController {

	@Autowired
	private LoanService loanService;

	@RequestMapping(value = "/vehicle/create", method = RequestMethod.GET)
	public ModelAndView showVehicleLoanLandingPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/loan/vehicleloan");
		return modelAndView;
	}

	@RequestMapping(value = "/vehicle/create", method = RequestMethod.POST)
	public ModelAndView createVehicleLoan(VehicleLoanRequest vehicleLoanRequest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/home");

		LoanServiceRequest loanServiceRequest = new VehicleLoanServiceRequest();
		loanServiceRequest.setLoanType(LoanType.VEHICLE);
		loanServiceRequest.setLoanStatus(LoanStatusType.valueOf(vehicleLoanRequest.getLoanStatus().toUpperCase()));
		CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();

		BeanUtils.copyProperties(vehicleLoanRequest, loanServiceRequest);

		customerServiceRequest.setName(vehicleLoanRequest.getCustomerName());
		BeanUtils.copyProperties(vehicleLoanRequest, customerServiceRequest);
		customerServiceRequest.setContactNumber(vehicleLoanRequest.getPhoneNumber());

		loanService.createLoanWithCustomer(loanServiceRequest, customerServiceRequest);

		return modelAndView;
	}

	@RequestMapping(value = "/home/create", method = RequestMethod.GET)
	public ModelAndView showHomeLoanLandingPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/loan/homeloan");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/home/create", method = RequestMethod.POST)
	public ModelAndView createHomeLoan(BaseLoanRequest homeLoanRequest) {
		ModelAndView modelAndView = new ModelAndView();
		LoanServiceRequest loanServiceRequest = new LoanServiceRequest();
		loanServiceRequest.setLoanType(LoanType.HOME);
		loanServiceRequest.setLoanStatus(LoanStatusType.valueOf(homeLoanRequest.getLoanStatus().toUpperCase()));
		CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();
		BeanUtils.copyProperties(homeLoanRequest, loanServiceRequest);

		customerServiceRequest.setName(homeLoanRequest.getCustomerName());
		BeanUtils.copyProperties(homeLoanRequest, customerServiceRequest);
		customerServiceRequest.setContactNumber(homeLoanRequest.getPhoneNumber());

		loanService.createLoanWithCustomer(loanServiceRequest, customerServiceRequest);

		
		modelAndView.setViewName("/admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/kcc/create", method = RequestMethod.GET)
	public ModelAndView showKCCLoanLandingPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/loan/kccloan");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/kcc/create", method = RequestMethod.POST)
	public ModelAndView createKCCLoan(BaseLoanRequest homeLoanRequest) {
		ModelAndView modelAndView = new ModelAndView();
		LoanServiceRequest loanServiceRequest = new LoanServiceRequest();
		loanServiceRequest.setLoanType(LoanType.KCC);
		loanServiceRequest.setLoanStatus(LoanStatusType.valueOf(homeLoanRequest.getLoanStatus().toUpperCase()));
		CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();
		BeanUtils.copyProperties(homeLoanRequest, loanServiceRequest);

		customerServiceRequest.setName(homeLoanRequest.getCustomerName());
		BeanUtils.copyProperties(homeLoanRequest, customerServiceRequest);
		customerServiceRequest.setContactNumber(homeLoanRequest.getPhoneNumber());

		loanService.createLoanWithCustomer(loanServiceRequest, customerServiceRequest);

		modelAndView.setViewName("/admin/home");
		return modelAndView;
	}
}
