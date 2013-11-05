package com.hskj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hskj.exception.MyException;
import com.hskj.util.ConUtil;

@Controller
public class LoginController {
	@Autowired
	TestService testService;
	@RequestMapping("/login.do")
	public String login(){
		System.out.println("login.do controller");
		return "index";
	}
	@RequestMapping("/test.do")
	public String test() throws MyException{
		ConUtil c  = new ConUtil();
		c.f();
		System.out.println("test.do controller");
		return "index";
	}
	@RequestMapping("/other.do")
	public String other(){
		System.out.println("other.do controller");
		return "index";
	}
	
	@RequestMapping("/anoymous.do")
	public String anoymous(){
		String username = null; 
		 Object principal = SecurityContextHolder.getContext() 
	        .getAuthentication().getPrincipal(); 
	    if (principal instanceof UserDetails) { 
	        username = ((UserDetails) principal).getUsername(); 
	    } else { 
	        username = principal.toString(); 
	    } 
		System.out.println("anoymous.do controller"+username);
		return "index";
	}
}
