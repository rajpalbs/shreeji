package com.finanace.shreeji.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.finanace.shreeji.model.OldRole;
import com.finanace.shreeji.model.OldUser;
import com.finanace.shreeji.repository.RoleRepository;
import com.finanace.shreeji.repository.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public OldUser findUserByEmail(String email) {
		return null;//userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(OldUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        //OldRole userRole = roleRepository.findByRole("ADMIN");
        //user.setRoles(new HashSet<OldRole>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}