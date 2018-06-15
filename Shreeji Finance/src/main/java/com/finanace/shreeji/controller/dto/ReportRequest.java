package com.finanace.shreeji.controller.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReportRequest {
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date fromDate;

	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date toDate;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
