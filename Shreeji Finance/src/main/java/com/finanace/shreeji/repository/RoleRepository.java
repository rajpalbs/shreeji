
package com.finanace.shreeji.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.model.Role;
import com.finanace.shreeji.model.Role.RoleType;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, UUID> {
	Role findByName(RoleType role);
}