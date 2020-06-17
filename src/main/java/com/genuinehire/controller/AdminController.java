package com.genuinehire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.domain.User;
import com.genuinehire.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute User admin, Authentication authentication) {
		admin = userService.getUserByUsername(authentication.getName());
		if (admin == null) {
			return "/doLogin";
		}
		return "/admin/home";
	}
	
	@RequestMapping(value = "/profile")
	public String profile(ModelMap model, Authentication authentication) {
		User admin = userService.getUserByUsername(authentication.getName());
		model.addAttribute("admin", admin);
		return "/admin/profile";
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

}
