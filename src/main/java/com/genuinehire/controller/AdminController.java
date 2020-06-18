package com.genuinehire.controller;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String home(@ModelAttribute JobSeeker jobSeeker, Model model) {
 		model.addAttribute("JobSeeker",jobSeeker);
		return "admin/admin-search";
	}

	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String welcomeUser(@RequestParam("firstName") String name,Model model) {
		model.addAttribute("lists",adminService.getUserByUsername(name));
		return "admin/list";
	}

}
