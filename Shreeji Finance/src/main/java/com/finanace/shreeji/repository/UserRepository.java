package com.finanace.shreeji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanace.shreeji.model.OldUser;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<OldUser, Long> {
	 OldUser findByEmail(String email);
}