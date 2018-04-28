package com.finanace.shreeji.service;

import java.util.List;

import com.finanace.shreeji.model.OldLoan;

public interface LoanService {
	public void saveLoan(OldLoan loan);
	public List<OldLoan> listAll();
}
