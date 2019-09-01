/*
	Code of me
*/
package com.dxc.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.finalproject.dao.UserDAO;
import com.dxc.finalproject.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/logincheck", method=RequestMethod.POST)
	public String checkLogin(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		HttpSession session = request.getSession();
		User u = userDAO.checkLogin(userName, passWord);
		if(u != null) {
			session.setAttribute("userId", u.getId());
			session.setAttribute("userRole", u.getUserRole());
			return "home";
		} else {
			return "login";
		}
		
	}
	@RequestMapping(value="/alluser", method=RequestMethod.GET)
	public ModelAndView manageUser() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickAllUser", true);
		mv.addObject("users", userDAO.findAllUser());
		return mv;
	}
	@RequestMapping(value="/registeruser",method=RequestMethod.GET)
	public ModelAndView registerUser() {
		ModelAndView mv= new ModelAndView("home");
		mv.addObject("userClickRegister", true);
		return mv;
	}
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView("redirect:/alluser");
		User u = new User();
		u.setUserName(request.getParameter("name"));
		u.setPassWord(request.getParameter("pass"));
		u.setDecentralization(2);
		u.setEmployeeId(1);
		u.setUserRole(2);
		userDAO.addUser(u);
		mv.addObject("addUserSuccess", true);
		return mv;
	}
	@RequestMapping(value="/editUser/{id}",method=RequestMethod.GET)
	public ModelAndView updateUser(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		User u = userDAO.getUserById(Integer.parseInt(id));
		mv.addObject("userClickEdit", true);
		mv.addObject("user", u);	
		return mv;
	}
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public ModelAndView updateUser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/alluser");
		User us = userDAO.getUserById(Integer.parseInt(request.getParameter("id")));
		User u  = new User();
		u.setId(Integer.parseInt(request.getParameter("id")));
		u.setUserName(request.getParameter("name"));
		u.setPassWord("pass");
		u.setDecentralization(2);
		u.setEmployeeId(us.getEmployeeId());
		u.setUserRole(2);
		boolean status = userDAO.updateUser(u);
		return mv;
	}
	@RequestMapping(value="/deleteUser/{id}",method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("redirect:/alluser");
		boolean status = userDAO.deleteUser(Integer.parseInt(id));
		return mv;
	}
}
