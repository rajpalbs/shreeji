package com.finanace.shreeji.service;

import java.util.Date;
import java.util.List;

import com.finanace.shreeji.model.dto.LoanReportDTO;
import com.finanace.shreeji.service.dto.CustomerServiceRequest;
import com.finanace.shreeji.service.dto.LoanServiceRequest;

public interface LoanService {

	public void createLoanWithCustomer(LoanServiceRequest loanServiceRequest, CustomerServiceRequest customerServiceRequest);

	public List<LoanReportDTO> getLoanReport(Date fromDate, Date toDate);

}
