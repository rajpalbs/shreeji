package com.finanace.shreeji.service;

import java.util.List;

import com.finanace.shreeji.model.Loan;

public interface LoanService {
	public void saveLoan(Loan loan);
	public List<Loan> listAll();
}
