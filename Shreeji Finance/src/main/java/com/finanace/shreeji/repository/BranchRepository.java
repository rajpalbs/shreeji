package com.finanace.shreeji.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.model.Branch;

@Repository("branchRepository")
public interface BranchRepository extends JpaRepository<Branch, UUID> {
}