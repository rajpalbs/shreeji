package com.finanace.shreeji.service;

import java.util.UUID;

import com.finanace.shreeji.model.Branch;
import com.finanace.shreeji.service.dto.BranchServiceResponse;

public interface BranchService {
	public BranchServiceResponse findById(UUID id);
	public Branch repoFindById(UUID id);

}
