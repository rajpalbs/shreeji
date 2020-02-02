package com.finanace.shreeji.controller.dto;

public class ReportRequest {

	private String fromDate;
	private String toDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "ReportRequest [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

}
