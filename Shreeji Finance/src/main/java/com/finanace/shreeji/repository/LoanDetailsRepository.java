package com.finanace.shreeji.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.model.LoanDetail;

@Repository("loanDetailsRepository")
public interface LoanDetailsRepository extends JpaRepository<LoanDetail, UUID> {
}
