package com.finanace.shreeji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.Employee;
import com.finanace.shreeji.repository.BranchRepository;
import com.finanace.shreeji.repository.EmployeeRepository;
import com.finanace.shreeji.repository.RoleRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	public void createEmployee(Employee employee) {
		employee.setRole(roleRepository.findOne(employee.getRole().getId()));
		employee.setBranch(branchRepository.findOne(employee.getBranch().getId()));
		employeeRepository.save(employee);
	}
}
