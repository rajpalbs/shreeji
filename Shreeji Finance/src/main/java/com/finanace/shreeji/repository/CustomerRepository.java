package com.finanace.shreeji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.model.OldCustomer;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<OldCustomer, Integer> {

}
