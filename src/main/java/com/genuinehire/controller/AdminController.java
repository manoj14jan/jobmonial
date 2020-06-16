package com.genuinehire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genuinehire.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

}
