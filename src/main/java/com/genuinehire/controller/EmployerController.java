package com.genuinehire.controller;

import com.genuinehire.domain.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genuinehire.service.EmployerService;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;

	@RequestMapping("/register")
	public String registrationPage(Map<String,Object> model){
		Employer employer = new Employer();
		model.put("employer", employer);
		return "register-employer";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registrationPagePost(@ModelAttribute("employer") Employer employer){
		employerService.save(employer);
		return "success";
	}

}
