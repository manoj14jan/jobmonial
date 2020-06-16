package com.genuinehire.controller;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.JobSeeker;
import com.genuinehire.domain.User;
import com.genuinehire.scurity.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.genuinehire.service.EmployerService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute Employer employer, Authentication authentication) {
		employer = employerService.getEmployerByUserUsername(authentication.getName());

		if (employer == null) {
			return "employer/employer-form";
		}

		return "/employer/employer-home";
	}

	@RequestMapping(value = "/profile/save")
	public String saveProfile(@Valid @ModelAttribute("employer") Employer employer, BindingResult bindingResult,RedirectAttributes redirectAttributes, Authentication authentication) {
		if(bindingResult.hasErrors()){
			return "employer/employer-form";
		}
		if(authentication != null){
			CustomUserDetails o = (CustomUserDetails)authentication.getPrincipal();
			employer.setUser(o.getUser());
			employerService.saveEmployer(employer);
		}
		return "redirect:/employer/profile";
	}

	@RequestMapping(value = "/profile")
	public String homes(Model m, Authentication authentication) {
		Employer employer = employerService.getEmployerByUserUsername(authentication.getName());
		m.addAttribute("employer", employer);
		return "/employer/employer-profile";
	}

	/*@RequestMapping(value = "/profile/update", method = RequestMethod.GET)
	public String jobSeekerRegisterForm(@ModelAttribute JobSeeker jobSeeker, Authentication authentication) {
		jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		return "/jobseeker/jobseeker-profile-update";
	}*/

}
