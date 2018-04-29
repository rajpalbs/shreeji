package com.finanace.shreeji.service;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.Branch;
import com.finanace.shreeji.repository.BranchRepository;
import com.finanace.shreeji.service.dto.BranchServiceResponse;

@Service("branchService")
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository; 
	
	@Override
	public BranchServiceResponse findById(UUID id) {
		Branch branchEntity = repoFindById(id);
		BranchServiceResponse branchServiceResponse = new BranchServiceResponse();
		BeanUtils.copyProperties(branchEntity, branchServiceResponse);
		return branchServiceResponse;
	}

	@Override
	public Branch repoFindById(UUID id) {
		return branchRepository.findOne(id);
	}
}
