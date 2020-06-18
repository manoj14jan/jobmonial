package com.genuinehire.controller;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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


	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String home(@ModelAttribute JobSeeker jobSeeker, Model model) {
 model.addAttribute("JobSeeker",jobSeeker);
	return "admin/admin-search";
	}

	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String welcomeUser(@RequestParam("firstName") String name,Model model) {
		model.addAttribute("lists",userService.getUserByUsername(name));
		return "admin/list";
	}

}
