package com.dxc.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.finalproject.dao.CustomerDao;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping(value="/allcustomer", method=RequestMethod.GET)
	public ModelAndView manageUser() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickAllCustomer", true);
		mv.addObject("customers", customerDao.findAllCustomer());
		return mv;
	}
	@RequestMapping(value="/deleteCustomer/{id}",method=RequestMethod.GET)
	public ModelAndView deleteCustomer(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("redirect:/allcustomer");
		boolean status = customerDao.deleteCustomer(Integer.parseInt(id));
		return mv;  
	}
}
