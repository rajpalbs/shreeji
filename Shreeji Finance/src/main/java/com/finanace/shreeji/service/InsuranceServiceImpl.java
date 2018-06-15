package com.finanace.shreeji.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.Customer;
import com.finanace.shreeji.model.Employee;
import com.finanace.shreeji.model.Insurance;
import com.finanace.shreeji.repository.CustomerRepository;
import com.finanace.shreeji.repository.EmployeeRepository;
import com.finanace.shreeji.repository.InsuranceRepository;
import com.finanace.shreeji.service.dto.CustomerServiceRequest;
import com.finanace.shreeji.service.dto.InsuranceServiceRequest;

@Service("insuranceService")
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceRepository insuranceRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public void storeInsuranceDetails(InsuranceServiceRequest insuranceServiceRequest,CustomerServiceRequest customerServiceRequest) {
		Insurance insuranceEntity = new Insurance();
		
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.getUsername();
		Employee employee = employeeRepository.findByEmail(username);
		insuranceEntity.setEmployee(employee);
		insuranceEntity.setBranch(employee.getBranch());
		
		// create customer
		Customer customerEntity = new Customer();
		BeanUtils.copyProperties(customerServiceRequest, customerEntity);
		customerEntity = customerRepository.save(customerEntity);
		insuranceEntity.setCustomer(customerEntity);

		BeanUtils.copyProperties(insuranceServiceRequest,insuranceEntity);
		insuranceRepository.save(insuranceEntity);
	}
}
