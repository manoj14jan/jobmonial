package com.genuinehire.controller;

import javax.validation.Valid;

import com.genuinehire.domain.Job;
import com.genuinehire.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.domain.User;
import com.genuinehire.service.JobSeekerService;
import com.genuinehire.service.UserService;
import com.genuinehire.util.Role;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private JobService jobService;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/home")
	public String home(Authentication authentication) {
		User user = userService.getUserByUsername(authentication.getName());

		if (user.getRole().contains("ROLE_ADMIN")) {
			return "redirect:/admin/home";
		}

		if (user.getRole().contains("ROLE_EMPLOYER")) {
			return "redirect:/employer/home";
		}

		if (user.getRole().contains("ROLE_JOBSEEKER")) {
			return "redirect:/jobseeker/home";
		}

		return "home";
	}

	@RequestMapping(value = "/register/{userType}", method = RequestMethod.GET)
	public String registerForm(@ModelAttribute User user, @PathVariable String userType) {
		if ("jobseeker".equalsIgnoreCase(userType)) {
			user.setRole(Role.ROLE_JOBSEEKER.toString());
		} else if ("employer".equalsIgnoreCase(userType)) {
			user.setRole(Role.ROLE_EMPLOYER.toString());
		} else {
			throw new RuntimeException("UserTypeNotSupportedException");
		}
		return "register-form";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "register-form";
		}
		user = userService.addUser(user);
		redirectAttributes.addFlashAttribute(user);
		return "redirect:/register/success";
	}

	@RequestMapping(value = "/register/success", method = RequestMethod.GET)
	public String registerSuccess(@ModelAttribute User user) {
		return "register-success";
	}


	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public String showJobs(Model m) {
		List<Job> jobList = jobService.getAll();
		m.addAttribute("jobs", jobList);
		return "employer/employer-jobs";
	}

	// Job seeker registration
	/*
	 * @RequestMapping(value = "/register/jobseeker", method = RequestMethod.GET)
	 * public String jobSeekerRegisterForm(@ModelAttribute JobSeeker jobSeeker) {
	 * return "/jobseeker/jobseeker-register-form"; }
	 * 
	 * @RequestMapping(value = "/register/jobseeker", method = RequestMethod.POST)
	 * public String jobSeekerRegister(@Valid @ModelAttribute JobSeeker jobSeeker,
	 * BindingResult bindingResult, RedirectAttributes redirectAttributes) { if
	 * (bindingResult.hasErrors()) { return "/jobseeker/jobseeker-register-form"; }
	 * jobSeeker = jobSeekerService.saveJobSeeker(jobSeeker);
	 * redirectAttributes.addFlashAttribute(jobSeeker); return
	 * "redirect:/register/jobseeker/success";
	 * 
	 * }
	 * 
	 * // @RequestMapping(value = "/register/jobseeker/success", method =
	 * RequestMethod.GET) // public String jobSeekerRegisterSuccess(@ModelAttribute
	 * JobSeeker jobSeeker) { // return "/jobseeker/jobseeker-register-success"; //
	 * }
	 */

	@RequestMapping(value = "/loginForm")
	public String loginForm() {
		return "login-form";
	}

	@RequestMapping(value = "/error403")
	public String error() {
		return "error403";
	}

}
