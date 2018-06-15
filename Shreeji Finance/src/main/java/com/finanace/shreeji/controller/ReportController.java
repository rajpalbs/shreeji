package com.finanace.shreeji.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finanace.shreeji.controller.dto.ReportRequest;

@RequestMapping("/report/*")
public class ReportController {

	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public void downloadXLSReport(ReportRequest reportRequest) {
		
	}
}
