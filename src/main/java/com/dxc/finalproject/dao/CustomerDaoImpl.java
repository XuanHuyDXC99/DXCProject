package com.dxc.finalproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.finalproject.model.Customer;
import com.dxc.finalproject.model.User;

@Repository("customerDAO")
@Transactional(rollbackFor = Exception.class)
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> list = new ArrayList<>();
		String hql = "FROM Customer";
		list = sessionFactory.getCurrentSession().createQuery(hql, Customer.class).getResultList();
		return list;
	}
	@Override
	public boolean deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Customer u =session.get(Customer.class ,id);
			session.delete(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
