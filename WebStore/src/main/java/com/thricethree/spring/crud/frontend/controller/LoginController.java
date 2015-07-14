package com.thricethree.spring.crud.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

	//Home
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView home(){
		System.out.println("==== In Home ====");
		ModelAndView model = new ModelAndView();
		model.setViewName("common/home");
		return model;
	}
	
	//Login/logout
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value="error", required=false) String error,
		@RequestParam(value="logout", required=false) String logout){
		System.out.println("==== in login: error=" + error 
					+ ", logout=" + logout +" ====");
		ModelAndView model = new ModelAndView();
		if(error!=null){
			model.addObject("error", "Invalid login information!");
		}
		if(logout!=null){
			model.addObject("logoutMsg", "Successfuly logged out!");
		}
		model.setViewName("common/login");
		return model;
	}
	
	// Access denied, no privilege
	@RequestMapping(value="/accessDenied", method=RequestMethod.GET)
	public ModelAndView accessDenied(){
		System.out.println("==== In accessDenied ====");
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "You don't have the privilege to access this resource.");
		model.setViewName("common/home");
		return model;
	}
}
