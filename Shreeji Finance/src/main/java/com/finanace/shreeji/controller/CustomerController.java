package com.finanace.shreeji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.model.Customer;
import com.finanace.shreeji.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public ModelAndView customerCreatePage() {
		Customer customer = new Customer();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customer", customer);
		modelAndView.setViewName("customer/create");
		return modelAndView;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public ModelAndView customerCreatePage(@Valid Customer customer) {
		System.out.println(customer);
		customerService.SaveCustomer(customer);
		List<Customer> allCustomer = customerService.listAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customers", allCustomer);
		modelAndView.setViewName("customer/listAll");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/update" }, method = RequestMethod.GET)
	public ModelAndView customerUpdatePage() {
		Customer customer = new Customer();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customer", customer);
		modelAndView.setViewName("customer/update");
		return modelAndView;
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public ModelAndView customerUpdatePage(@Valid Customer customer) {
		customerService.SaveCustomer(customer);
		List<Customer> allCustomer = customerService.listAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customers", allCustomer);
		modelAndView.setViewName("customer/update");
		return modelAndView;
	}

	
	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ModelAndView customerSearchPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer/search");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public ModelAndView customerSearchPage(String searchString) {
		ModelAndView modelAndView = new ModelAndView();
		List<Customer> allCustomer = customerService.listAll();
		modelAndView.addObject("customers", allCustomer);
		modelAndView.setViewName("customer/search");
		return modelAndView;
	}
}
