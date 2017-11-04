package com.finanace.shreeji.service;

import com.finanace.shreeji.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}