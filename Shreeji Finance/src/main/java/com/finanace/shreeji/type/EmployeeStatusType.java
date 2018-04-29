package com.finanace.shreeji.type;

public enum EmployeeStatusType {
	
	ACTIVE(1),INACTIVE(0);
	
	private int status;
	
	EmployeeStatusType(int status) {
		this.status = status;
	}
	
	public int getEmployeeStatus() {
		return this.status;
	} 
}
