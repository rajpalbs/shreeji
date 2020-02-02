package com.finanace.shreeji.bo;

public class Remark {
	private String date;
	private String remark;

	public Remark(){}
	
	public Remark(String date, String remark) {
		super();
		this.date = date;
		this.remark = remark;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
