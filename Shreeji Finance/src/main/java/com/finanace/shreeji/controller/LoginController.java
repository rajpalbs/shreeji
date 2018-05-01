package com.finanace.shreeji.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.controller.dto.EmployeeRegistrationRequest;
import com.finanace.shreeji.model.Branch;
import com.finanace.shreeji.model.Employee;
import com.finanace.shreeji.repository.BranchRepository;
import com.finanace.shreeji.service.EmployeeService;
import com.finanace.shreeji.service.dto.EmployeeRegistrationServiceRequest;
import com.finanace.shreeji.service.dto.EmployeeServiceResponse;
import com.finanace.shreeji.type.EmployeeStatusType;
import com.finanace.shreeji.type.RoleType;

@Controller
public class LoginController {

	@Autowired
	private BranchRepository branchRepository;
	
    @Autowired
    private EmployeeService employeeService; 

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		//TODO : Remove below two lines for sending empty employee object 
		Employee employee = new Employee();
		modelAndView.addObject("employee", employee);
		
		List<Branch> branches = new ArrayList<>();
		branches = branchRepository.findAll();
		modelAndView.addObject("branches", branches);
		
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid EmployeeRegistrationRequest employeeRegistrationRequest, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		EmployeeRegistrationServiceRequest employeeRegistrationServiceRequest = new EmployeeRegistrationServiceRequest();
		BeanUtils.copyProperties(employeeRegistrationRequest,employeeRegistrationServiceRequest);
		employeeRegistrationServiceRequest.setRoleType(RoleType.ADMIN);
		employeeRegistrationServiceRequest.setEmployeeStatusType(EmployeeStatusType.ACTIVE);
		
		//TODO : Create custom service exception 
		employeeService.createEmployee(employeeRegistrationServiceRequest);
		
		//TODO : Remove below two lines for sending empty employee object 
		EmployeeRegistrationRequest employee = new EmployeeRegistrationRequest();
		modelAndView.addObject("employee", employee);
		
		List<Branch> branches = new ArrayList<>();
		branches = branchRepository.findAll();
		modelAndView.addObject("branches", branches);
		modelAndView.addObject("successMessage","EMPLOYEE WITH email ADDRESS "+employeeRegistrationRequest.getEmail()+" CREATED SUCCESSFULLY !!!");
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		EmployeeServiceResponse user = employeeService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

}
