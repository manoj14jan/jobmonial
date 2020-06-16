package com.genuinehire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genuinehire.service.EmployerService;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;
	

}
