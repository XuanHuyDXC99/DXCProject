/*
	Code of me
*/
package com.dxc.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/","/login"})
	public String loginPage() {
		return "login";
	}
}
