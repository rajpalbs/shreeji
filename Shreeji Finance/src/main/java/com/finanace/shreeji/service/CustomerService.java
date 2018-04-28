package com.finanace.shreeji.service;

import java.util.List;

import com.finanace.shreeji.model.OldCustomer;


public interface CustomerService {
	public void SaveCustomer(OldCustomer customer);
	public List<OldCustomer> listAll();
}
