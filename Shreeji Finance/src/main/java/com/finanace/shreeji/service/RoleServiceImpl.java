package com.finanace.shreeji.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.Role;
import com.finanace.shreeji.repository.RoleRepository;
import com.finanace.shreeji.service.dto.RoleServiceResponse;
import com.finanace.shreeji.type.RoleType;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;  
	
	@Override
	public RoleServiceResponse findByName(RoleType roleType) {
		RoleServiceResponse roleServiceResponse = new RoleServiceResponse();
		Role role = repoFindByName(roleType);
		BeanUtils.copyProperties(role, roleServiceResponse);
		return roleServiceResponse;
	}

	@Override
	public Role repoFindByName(RoleType roleType) {
		return roleRepository.findByName(roleType);
	}
}
