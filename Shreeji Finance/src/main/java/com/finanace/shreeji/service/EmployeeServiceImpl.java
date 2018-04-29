package com.finanace.shreeji.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.Employee;
import com.finanace.shreeji.repository.EmployeeRepository;
import com.finanace.shreeji.service.dto.EmployeeRegistrationServiceRequest;
import com.finanace.shreeji.service.dto.EmployeeServiceResponse;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private BranchService branchService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void createEmployee(EmployeeRegistrationServiceRequest employeeRegistrationServiceRequest) {

		Employee employeeEntity = new Employee();

		BeanUtils.copyProperties(employeeRegistrationServiceRequest, employeeEntity);
		employeeEntity.setStatus(employeeRegistrationServiceRequest.getEmployeeStatusType().getEmployeeStatus());
		employeeEntity.setPassword(bCryptPasswordEncoder.encode(employeeRegistrationServiceRequest.getPassword()));

		employeeEntity.setRole(roleService.repoFindByName(employeeRegistrationServiceRequest.getRoleType()));
		employeeEntity.setBranch(branchService.repoFindById(employeeRegistrationServiceRequest.getBranch()));
		employeeRepository.save(employeeEntity);
	}

	@Override
	public EmployeeServiceResponse findUserByEmail(String email) {
		Employee employeeEntity = employeeRepository.findByEmail(email);
		EmployeeServiceResponse employeeServiceResponse = new EmployeeServiceResponse();
		BeanUtils.copyProperties(employeeEntity,employeeServiceResponse);
		return employeeServiceResponse;
	}
}
