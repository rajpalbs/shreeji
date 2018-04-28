package com.finanace.shreeji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.OldCustomer;
import com.finanace.shreeji.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void SaveCustomer(OldCustomer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<OldCustomer> listAll() {
		return customerRepository.findAll();
	}

}
