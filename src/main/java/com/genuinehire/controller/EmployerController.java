package com.genuinehire.controller;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute Employer employer, Authentication authentication) {
		employer = employerService.getEmployerByUsername(authentication.getName());

		if (employer == null) {
			return "employer/employer-form";
		}

		return "/employer/employer-home";
	}

	@RequestMapping(value = "/profile")
	public String homes(@ModelAttribute Employer employer, Authentication authentication) {
		employer = employerService.getEmployerByUsername(authentication.getName());
		return "/employer/employer-profile";
	}

	/*@RequestMapping(value = "/profile/update", method = RequestMethod.GET)
	public String jobSeekerRegisterForm(@ModelAttribute JobSeeker jobSeeker, Authentication authentication) {
		jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		return "/jobseeker/jobseeker-profile-update";
	}*/

}
