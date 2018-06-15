package com.finanace.shreeji.service;

import com.finanace.shreeji.service.dto.CustomerServiceRequest;
import com.finanace.shreeji.service.dto.InsuranceServiceRequest;

public interface InsuranceService {
	public void storeInsuranceDetails(InsuranceServiceRequest insuranceServiceRequest,CustomerServiceRequest customerServiceRequest);
}
