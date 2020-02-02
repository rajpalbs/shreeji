package com.finanace.shreeji.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.bo.Customer;
import com.finanace.shreeji.bo.Financer;
import com.finanace.shreeji.bo.Lead;
import com.finanace.shreeji.bo.Loan;
import com.finanace.shreeji.bo.Vehicle;
import com.finanace.shreeji.service.ConfigManagementService;
import com.finanace.shreeji.service.LeadManagementService;

@Controller
public class LeadManagementController {

	@Autowired
	private LeadManagementService leadManagementService;

	@Autowired
	private ConfigManagementService configManagementService;

	@RequestMapping(value = { "/", "/lead" }, method = RequestMethod.GET)
	public ModelAndView homePage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/lead/home");

		setAgentName(modelAndView);

		return modelAndView;
	}

	@RequestMapping(value = "/lead/create", method = RequestMethod.GET)
	public ModelAndView landingPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/lead/create");

		setAgentName(modelAndView);

		return modelAndView;
	}

	@RequestMapping(value = "/lead/create", method = RequestMethod.POST)
	public ModelAndView createLead(LeadRequest request) {
		Lead leadBO = createLeadBO(request);
		Lead createdLead = leadManagementService.saveAndRetrieveLead(leadBO);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", createdLead.getId());
		setAgentName(modelAndView);
		modelAndView.setViewName("/lead/create");
		return modelAndView;
	}

	private void setRemarks(ModelAndView modelAndView, String leadId) {
		modelAndView.addObject("remarks", leadManagementService.getAllRemarksOfLead(leadId));
	}

	@RequestMapping(value = "/lead/view", method = RequestMethod.POST)
	public ModelAndView viewLead(String leadId) {

		ModelAndView modelAndView = new ModelAndView();
		Lead lead = leadManagementService.getLeadBySearchString(leadId);
		modelAndView.addObject("lead", lead);

		setAgentName(modelAndView);
		setFinancerBank(modelAndView);
		setRemarks(modelAndView, lead.getId());

		modelAndView.setViewName("/lead/view");
		return modelAndView;
	}

	@RequestMapping(value = "/lead/update", method = RequestMethod.POST)
	public ModelAndView updateLead(LeadRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		Lead leadBO = createLeadBO(request);

		leadManagementService.updateLead(leadBO);

		Lead lead = leadManagementService.getLeadByLeadId(request.getId());
		modelAndView.addObject("lead", lead);

		setAgentName(modelAndView);
		setFinancerBank(modelAndView);
		setRemarks(modelAndView, request.getId());

		modelAndView.setViewName("/lead/view");
		return modelAndView;
	}

	private void setAgentName(ModelAndView modelAndView) {
		List<String> agentNames = configManagementService.getAgentNames();
		modelAndView.addObject("agentNames", agentNames);
	}

	private void setFinancerBank(ModelAndView modelAndView) {
		List<String> financerBankNames = configManagementService.getFinancerBankNames();
		modelAndView.addObject("financerBankNames", financerBankNames);
	}

	private Lead createLeadBO(LeadRequest request) {
		Lead leadBO = new Lead();
		if (request.getId() == null) {
			leadBO.setId("" + (System.currentTimeMillis() / 1000));
		} else {
			leadBO.setId(request.getId());
		}

		if (request.getStatus() == null) {
			leadBO.setStatus("OPEN");
		} else {
			leadBO.setStatus(request.getStatus());
		}

		leadBO.setGivenBy(request.getInquiryGivenBy());
		leadBO.setInquiryDate(request.getInquiryDate());
		leadBO.setRemark(request.getRemark());

		Vehicle vehicle = new Vehicle();
		vehicle.setName(request.getVehicleName());
		vehicle.setCondition(request.getVehicleCondition());
		vehicle.setRegistrationNumber(request.getVehicleRegistarionNumber());
		vehicle.setType(request.getVehicleType());
		vehicle.setManufactureYear(Integer.parseInt(request.getVehicleManufacturYear()));
		leadBO.setVehicle(vehicle);

		Customer customer = new Customer();
		customer.setName(request.getCustomerName());
		customer.setMobileNumber1(request.getCustomerContactNumber1());
		customer.setMobileNumber2(request.getCustomerContactNumber2());
		customer.setVillage(request.getCustomerVillage());
		customer.setTaluka(request.getCustomerTaluka());
		customer.setDistrict(request.getCustomerDistrict());
		leadBO.setCustomer(customer);

		Financer financer = new Financer();

		if (request.getFinanceBy() != null && request.getFinanceBy() != "") {
			financer.setBankName(request.getFinanceBy());
			financer.setExecutiveName(request.getFinanceExecutiveName());
			financer.setMobileNumber(request.getFinanceExecutiveContactNumber());
			financer.setAgreementDone(request.getIsAgreementDone());
		}
		leadBO.setFinancer(financer);

		if (request.getLoanNumber() != null && request.getLoanNumber() != "") {
			leadBO.setLoan(new Loan(request.getLoanDate(),request.getLoanNumber(), (int) request.getLoanAmount()));
		} else {
			leadBO.setLoan(new Loan());
		}

		return leadBO;
	}

}

class LeadRequest {
	private String id;
	private String status;
	private String inquiryDate;
	private String inquiryGivenBy;

	private String financeBy;
	private String isAgreementDone;
	private String financeExecutiveName;
	private String financeExecutiveContactNumber;
	private String loanDate;
	private String loanNumber;
	private int loanAmount;

	private String customerName;
	private String customerVillage;
	private String customerContactNumber1;
	private String customerTaluka;
	private String customerContactNumber2;
	private String customerDistrict;
	private String vehicleName;
	private String vehicleCondition;
	private String vehicleRegistarionNumber;
	private String vehicleType;
	private String vehicleManufacturYear;

	private String remark;

	public LeadRequest() {
		super();
	}

	public LeadRequest(String id, String status, String inquiryDate, String inquiryGivenBy, String financeBy,
			String isAgreementDone, String financeExecutiveName, String financeExecutiveContactNumber, String loanDate,
			String loanNumber, int loanAmount, String customerName, String customerVillage,
			String customerContactNumber1, String customerTaluka, String customerContactNumber2,
			String customerDistrict, String vehicleName, String vehicleCondition, String vehicleRegistarionNumber,
			String vehicleType, String vehicleManufacturYear, String remark) {
		super();
		this.id = id;
		this.status = status;
		this.inquiryDate = inquiryDate;
		this.inquiryGivenBy = inquiryGivenBy;
		this.financeBy = financeBy;
		this.isAgreementDone = isAgreementDone;
		this.financeExecutiveName = financeExecutiveName;
		this.financeExecutiveContactNumber = financeExecutiveContactNumber;
		this.loanDate = loanDate;
		this.loanNumber = loanNumber;
		this.loanAmount = loanAmount;
		this.customerName = customerName;
		this.customerVillage = customerVillage;
		this.customerContactNumber1 = customerContactNumber1;
		this.customerTaluka = customerTaluka;
		this.customerContactNumber2 = customerContactNumber2;
		this.customerDistrict = customerDistrict;
		this.vehicleName = vehicleName;
		this.vehicleCondition = vehicleCondition;
		this.vehicleRegistarionNumber = vehicleRegistarionNumber;
		this.vehicleType = vehicleType;
		this.vehicleManufacturYear = vehicleManufacturYear;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public String getInquiryGivenBy() {
		return inquiryGivenBy;
	}

	public void setInquiryGivenBy(String inquiryGivenBy) {
		this.inquiryGivenBy = inquiryGivenBy;
	}

	public String getFinanceBy() {
		return financeBy;
	}

	public void setFinanceBy(String financeBy) {
		this.financeBy = financeBy;
	}

	public String getIsAgreementDone() {
		return isAgreementDone;
	}

	public void setIsAgreementDone(String isAgreementDone) {
		this.isAgreementDone = isAgreementDone;
	}

	public String getFinanceExecutiveName() {
		return financeExecutiveName;
	}

	public void setFinanceExecutiveName(String financeExecutiveName) {
		this.financeExecutiveName = financeExecutiveName;
	}

	public String getFinanceExecutiveContactNumber() {
		return financeExecutiveContactNumber;
	}

	public void setFinanceExecutiveContactNumber(String financeExecutiveContactNumber) {
		this.financeExecutiveContactNumber = financeExecutiveContactNumber;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerVillage() {
		return customerVillage;
	}

	public void setCustomerVillage(String customerVillage) {
		this.customerVillage = customerVillage;
	}

	public String getCustomerContactNumber1() {
		return customerContactNumber1;
	}

	public void setCustomerContactNumber1(String customerContactNumber1) {
		this.customerContactNumber1 = customerContactNumber1;
	}

	public String getCustomerTaluka() {
		return customerTaluka;
	}

	public void setCustomerTaluka(String customerTaluka) {
		this.customerTaluka = customerTaluka;
	}

	public String getCustomerContactNumber2() {
		return customerContactNumber2;
	}

	public void setCustomerContactNumber2(String customerContactNumber2) {
		this.customerContactNumber2 = customerContactNumber2;
	}

	public String getCustomerDistrict() {
		return customerDistrict;
	}

	public void setCustomerDistrict(String customerDistrict) {
		this.customerDistrict = customerDistrict;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleCondition() {
		return vehicleCondition;
	}

	public void setVehicleCondition(String vehicleCondition) {
		this.vehicleCondition = vehicleCondition;
	}

	public String getVehicleRegistarionNumber() {
		return vehicleRegistarionNumber;
	}

	public void setVehicleRegistarionNumber(String vehicleRegistarionNumber) {
		this.vehicleRegistarionNumber = vehicleRegistarionNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleManufacturYear() {
		return vehicleManufacturYear;
	}

	public void setVehicleManufacturYear(String vehicleManufacturYear) {
		this.vehicleManufacturYear = vehicleManufacturYear;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "LeadRequest [id=" + id + ", status=" + status + ", inquiryDate=" + inquiryDate + ", inquiryGivenBy="
				+ inquiryGivenBy + ", financeBy=" + financeBy + ", isAgreementDone=" + isAgreementDone
				+ ", financeExecutiveName=" + financeExecutiveName + ", financeExecutiveContactNumber="
				+ financeExecutiveContactNumber + ", loanDate=" + loanDate + ", loanNumber=" + loanNumber
				+ ", loanAmount=" + loanAmount + ", customerName=" + customerName + ", customerVillage="
				+ customerVillage + ", customerContactNumber1=" + customerContactNumber1 + ", customerTaluka="
				+ customerTaluka + ", customerContactNumber2=" + customerContactNumber2 + ", customerDistrict="
				+ customerDistrict + ", vehicleName=" + vehicleName + ", vehicleCondition=" + vehicleCondition
				+ ", vehicleRegistarionNumber=" + vehicleRegistarionNumber + ", vehicleType=" + vehicleType
				+ ", vehicleManufacturYear=" + vehicleManufacturYear + ", remark=" + remark + "]";
	}

}
