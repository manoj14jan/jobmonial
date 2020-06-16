package com.genuinehire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.service.JobSeekerService;

@Controller
@RequestMapping(value = "/jobseeker")
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute JobSeeker jobSeeker, Authentication authentication) {
		jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		
		if (jobSeeker == null) {
			return "jobseeker/jobseeker-form";
		}
		
		return "/jobseeker/jobseeker-home";
	}

	@RequestMapping(value = "/profile")
	public String homes(ModelMap model, Authentication authentication) {
		JobSeeker jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		model.addAttribute("jobSeeker", jobSeeker);
		return "/jobseeker/jobseeker-profile";
	}

	@RequestMapping(value = "/profile/update", method = RequestMethod.GET)
	public String jobSeekerRegisterForm(@ModelAttribute JobSeeker jobSeeker, Authentication authentication) {
		jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		return "/jobseeker/jobseeker-profile-update";
	}

}
