package com.finanace.shreeji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.model.OldLoan;

@Repository("loanRepository")
public interface LoanRepository extends JpaRepository<OldLoan, Integer> {

}
