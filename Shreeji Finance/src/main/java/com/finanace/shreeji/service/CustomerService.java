package com.finanace.shreeji.service;

import java.util.List;

import com.finanace.shreeji.model.Customer;


public interface CustomerService {
	public void SaveCustomer(Customer customer);
	public List<Customer> listAll();
}
