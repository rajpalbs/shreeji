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
		BeanUtils.copyProperties(vehicleLoanRequest, loanServiceRequest);
		
		CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();
		customerServiceRequest.setName(vehicleLoanRequest.getCustomerName());
		BeanUtils.copyProperties(vehicleLoanRequest, customerServiceRequest);
		customerServiceRequest.setContactNumber(vehicleLoanRequest.getPhoneNumber());

		loanService.createLoanWithCustomer(loanServiceRequest, customerServiceRequest);

		Map<String, String> data = new LinkedHashMap<>();
		prepareVehicleLoanData(vehicleLoanRequest, data);
		modelAndView.addObject("data",data);	
		modelAndView.addObject("message", "Vehicle Loan recorded successfully with below details !!!");
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

		Map<String, String> data = new LinkedHashMap<>();
		prepareHomeAndKCCLoanData(homeLoanRequest, data);
		modelAndView.addObject("data",data);	
		modelAndView.addObject("message", "Home Loan recorded successfully with below details !!!");
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
	public ModelAndView createKCCLoan(BaseLoanRequest kccLoanRequest) {
		ModelAndView modelAndView = new ModelAndView();
		LoanServiceRequest loanServiceRequest = new LoanServiceRequest();
		loanServiceRequest.setLoanType(LoanType.KCC);
		loanServiceRequest.setLoanStatus(LoanStatusType.valueOf(kccLoanRequest.getLoanStatus().toUpperCase()));
		CustomerServiceRequest customerServiceRequest = new CustomerServiceRequest();
		BeanUtils.copyProperties(kccLoanRequest, loanServiceRequest);

		customerServiceRequest.setName(kccLoanRequest.getCustomerName());
		BeanUtils.copyProperties(kccLoanRequest, customerServiceRequest);
		customerServiceRequest.setContactNumber(kccLoanRequest.getPhoneNumber());

		loanService.createLoanWithCustomer(loanServiceRequest, customerServiceRequest);

		Map<String, String> data = new LinkedHashMap<>();
		prepareHomeAndKCCLoanData(kccLoanRequest, data);
		modelAndView.addObject("data",data);	
		modelAndView.addObject("message", "KCC Loan recorded successfully with below details !!!");
		
		modelAndView.setViewName("/admin/home");
		return modelAndView;
	}
	
	private void prepareVehicleLoanData(VehicleLoanRequest vehicleLoanRequest,Map<String, String> data){
		data.put("Loan Inquiry Date",new SimpleDateFormat("dd-MMM-yyyy").format(vehicleLoanRequest.getInquiryDate()));
		data.put("Customer Name", vehicleLoanRequest.getCustomerName());
		data.put("Vehicel Model", vehicleLoanRequest.getVehicleName());
		data.put("Vehicle Condition/mfg yr.", vehicleLoanRequest.getVehicleCondition()+
						(vehicleLoanRequest.getVehicleCondition().equalsIgnoreCase("new") ? "":"/"+vehicleLoanRequest.getManufacturingYear()));
		data.put("Finance By", vehicleLoanRequest.getFinancerName());
		data.put("Loan Amount", vehicleLoanRequest.getLoanAmount().toString());
		data.put("Commission Amount", vehicleLoanRequest.getCommissionAmount().toString());
		data.put("Loan Status", vehicleLoanRequest.getLoanStatus().toUpperCase());
		if(vehicleLoanRequest.getLoanStatus().equalsIgnoreCase("pass")){
			data.put("Loan Number", vehicleLoanRequest.getLoanNumber());
			data.put("Loan Date", new SimpleDateFormat("dd-MMM-yyyy").format(vehicleLoanRequest.getLoanDate()));
			data.put("Loan Commission", vehicleLoanRequest.getLoanCommissionAmount().toString());
		}else if(vehicleLoanRequest.getLoanStatus().equalsIgnoreCase("pending")){
			data.put("Remark", vehicleLoanRequest.getPendingRemark());
		}else if(vehicleLoanRequest.getLoanStatus().equalsIgnoreCase("cancelled")){
			data.put("Remark", vehicleLoanRequest.getCancelRemark());
		}
	}
	
	private void prepareHomeAndKCCLoanData(BaseLoanRequest baseLoanRequest,Map<String, String> data){
		data.put("Loan Inquiry Date",new SimpleDateFormat("dd-MMM-yyyy").format(baseLoanRequest.getInquiryDate()));
		data.put("Customer Name", baseLoanRequest.getCustomerName());
		data.put("Loan Amount", baseLoanRequest.getLoanAmount().toString());
		data.put("Commission Amount", baseLoanRequest.getCommissionAmount().toString());
		data.put("Loan Status", baseLoanRequest.getLoanStatus().toUpperCase());
		if(baseLoanRequest.getLoanStatus().equalsIgnoreCase("pass")){
			data.put("Loan Number", baseLoanRequest.getLoanNumber());
			data.put("Loan Date", new SimpleDateFormat("dd-MMM-yyyy").format(baseLoanRequest.getLoanDate()));
			data.put("Loan Commission", baseLoanRequest.getLoanCommissionAmount().toString());
		}else if(baseLoanRequest.getLoanStatus().equalsIgnoreCase("pending")){
			data.put("Remark", baseLoanRequest.getPendingRemark());
		}else if(baseLoanRequest.getLoanStatus().equalsIgnoreCase("cancelled")){
			data.put("Remark", baseLoanRequest.getCancelRemark());
		}		
	}
}
