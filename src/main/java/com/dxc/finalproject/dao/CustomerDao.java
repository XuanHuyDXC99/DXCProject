package com.dxc.finalproject.dao;

import java.util.List;

import com.dxc.finalproject.model.Customer;

public interface CustomerDao {
	public List<Customer> findAllCustomer();
	public boolean deleteCustomer(int id);
}
