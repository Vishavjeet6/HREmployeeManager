package com.nagarro.controllers;
/*
* Class name - UserController
*
* Version info - 0.3
*
* Copyright notice - @2020 Nagarro Private Limited.
* 
* Author info - Vishavjeet Singh
*
* Creation date - 17-03-2020
*
* Last updated By - Vishavjeet Singh
*
* Last updated Date - 19-03-2020
*
* Description -  provides mapping for login signup logout for hr
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/Login")
	public ModelAndView login(@RequestParam String userName, @RequestParam String password) {
		ModelAndView modelView = new ModelAndView();	
		if(!userService.validateUser(userName, password)) {
			modelView.setViewName("index");
			return modelView;
		}
		modelView.addObject("userName", userName);	
		modelView.setViewName("redirect:/employee");
		return modelView;
	}
	
	@RequestMapping("/Signup")
	public ModelAndView signUp(@RequestParam String userName, @RequestParam String password) {
		ModelAndView modelView = new ModelAndView();
		userService.addUser(userName, password);		
		modelView.addObject("userName", userName);
		modelView.setViewName("redirect:/employee");
		return modelView;
	}
	
	@RequestMapping("/Logout")
	public ModelAndView logOut() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("userName", null);
		modelView.setViewName("index");
		return modelView;
	}
}
