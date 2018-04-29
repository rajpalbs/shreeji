package com.finanace.shreeji.service;

import com.finanace.shreeji.model.Role;
import com.finanace.shreeji.service.dto.RoleServiceResponse;
import com.finanace.shreeji.type.RoleType;

public interface RoleService {
	//TODO : check wather we can remove either method by using generics
	public RoleServiceResponse findByName(RoleType roleType);
	public Role repoFindByName(RoleType roleType);
}
