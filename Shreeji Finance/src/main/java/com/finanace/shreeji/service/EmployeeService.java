package com.finanace.shreeji.service;

import com.finanace.shreeji.service.dto.EmployeeRegistrationServiceRequest;
import com.finanace.shreeji.service.dto.EmployeeServiceResponse;

public interface EmployeeService {

	void createEmployee(EmployeeRegistrationServiceRequest employeeRegistrationServiceRequest);
	EmployeeServiceResponse findUserByEmail(String email);

}
