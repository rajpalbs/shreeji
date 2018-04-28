package com.finanace.shreeji.service;

import com.finanace.shreeji.model.OldUser;

public interface UserService {
	public OldUser findUserByEmail(String email);
	public void saveUser(OldUser user);
}