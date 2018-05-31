package com.finanace.shreeji.service;

import com.finanace.shreeji.service.dto.CustomerServiceRequest;
import com.finanace.shreeji.service.dto.LoanServiceRequest;

public interface LoanService {

	void createLoanWithCustomer(LoanServiceRequest loanServiceRequest, CustomerServiceRequest customerServiceRequest);

}
