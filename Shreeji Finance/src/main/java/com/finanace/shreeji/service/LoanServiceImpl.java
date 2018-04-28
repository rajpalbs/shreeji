package com.finanace.shreeji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.OldLoan;
import com.finanace.shreeji.repository.LoanRepository;

@Service("loanService")
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepository loanRepository;

	@Override
	public void saveLoan(OldLoan loan) {
		loanRepository.save(loan);
	}

	@Override
	public List<OldLoan> listAll() {
		return loanRepository.findAll();
	}

}
