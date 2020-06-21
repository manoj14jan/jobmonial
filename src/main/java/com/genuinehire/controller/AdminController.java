package com.genuinehire.controller;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.JobSeeker;
import com.genuinehire.service.AdminService;
import com.genuinehire.service.EmployerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genuinehire.domain.User;
import com.genuinehire.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private EmployerService employerService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute User admin, Authentication authentication) {
		admin = userService.getUserByUsername(authentication.getName());
		if (admin == null) {
			return "/doLogin";
		}
		return "/admin/home";
	}

	
	@RequestMapping(value = "/add")
	public String display(@ModelAttribute User admin, Authentication authentication) {
		admin = userService.getUserByUsername(authentication.getName());
		return "/admin/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute User admin, Authentication authentication) {
		userService.addUser(admin);
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value = "/employerSearch", method = RequestMethod.GET)
	public String employerSearch(@ModelAttribute Employer employer, Model model) {
		model.addAttribute("Employer",employer);
		return "admin/employer-search";
	}
	
	@RequestMapping(value="/block", method=RequestMethod.POST)
	public String employerBlock(@RequestParam("name") Long user_id, Model model) {
		adminService.block(user_id);
		return "admin/employerList";
	}

	@RequestMapping(value="/employerSearch", method=RequestMethod.POST)
	public String employerSearchQuery(@RequestParam("name") String name, Model model) {
		model.addAttribute("lists",employerService.getEmployerByUserUsername(name));
		//model.addAttribute("lists",adminService.getUserByprofileTitle(profileTitle));
		return "admin/employerList";
	}

	@RequestMapping(value = "/jobSeekerSearch", method = RequestMethod.GET)
	public String home(@ModelAttribute JobSeeker jobSeeker, Model model) {
		model.addAttribute("JobSeeker",jobSeeker);
		return "admin/jobSeeker-search";
	}

	@RequestMapping(value="/jobSeekerSearch", method=RequestMethod.POST)
	public String welcomeUser( @RequestParam("profileTitle") String profileTitle, Model model) {
		  model.addAttribute("lists", adminService.getUserByprofileTitle( profileTitle));
		  return "admin/jobSeekerList";
	}



}
