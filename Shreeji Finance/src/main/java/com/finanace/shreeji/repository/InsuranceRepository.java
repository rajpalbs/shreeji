package com.finanace.shreeji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.model.OldInsurance;

@Repository("insuranceRepository")
public interface InsuranceRepository extends JpaRepository<OldInsurance, Integer> {

}
