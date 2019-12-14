package com.finanace.shreeji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finanace.shreeji.controller.dto.ReportRequest;
import com.finanace.shreeji.model.dto.LoanReportDTO;
import com.finanace.shreeji.service.LoanService;

@Controller
@RequestMapping("/report/*")
public class ReportController {

	@Autowired
	private LoanService loanService;
	
	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public void downloadXLSReport(ReportRequest reportRequest) {
		loanService.getLoanReport(reportRequest.getFromDate(), reportRequest.getToDate());
	}
}
