package com.genuinehire.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.genuinehire.domain.Job;
import com.genuinehire.domain.JobSeeker;
import com.genuinehire.domain.User;
import com.genuinehire.service.JobSeekerService;
import com.genuinehire.service.JobService;
import com.genuinehire.service.UserService;

@Controller
@RequestMapping(value = "/jobseeker")
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;

	@Autowired
	private UserService userService;

	@Autowired
	private JobService jobService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@ModelAttribute JobSeeker jobSeeker, Authentication authentication) {
		jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());

		if (jobSeeker == null) {
			return "jobseeker/jobseeker-form";
		}

		return "/jobseeker/jobseeker-home";
	}

	@RequestMapping(value = "/profile-form", method = RequestMethod.GET)
	public String profileForm(Model model, Authentication authentication) {
		JobSeeker jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		model.addAttribute(jobSeeker);
		return "jobseeker/jobseeker-form";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, Authentication authentication) {
		JobSeeker jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		model.addAttribute(jobSeeker);
		return "/jobseeker/jobseeker-profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profileUpdate(@Valid @ModelAttribute JobSeeker jobSeeker, BindingResult bindingResult,
			Authentication authentication) {
		if (bindingResult.hasErrors()) {
			return "jobseeker/jobseeker-form";
		}

		User user = userService.getUserByUsername(authentication.getName());
		jobSeeker.setUser(user);
		jobSeeker = jobSeekerService.saveJobSeeker(jobSeeker);
		return "redirect:/jobseeker/profile";
	}

	@RequestMapping(value = "/jobsearch", method = RequestMethod.GET)
	public String jobSearch() {
		return "jobseeker/jobsearch";
	}

	@RequestMapping(value = "/jobsearch", method = RequestMethod.POST)
	public String jobSearchDisplay(@RequestParam String skills, Model model) {
		List<Job> jobs = jobService.getJobBySkills(skills);
		System.out.println(jobs.size());
		model.addAttribute("jobs", jobs);
		return "jobseeker/jobsearch";
	}
	
	@RequestMapping(value = "/appliedjobs", method = RequestMethod.GET)
	public String appliedJobs(Model model, Authentication authentication) {
		JobSeeker jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		model.addAttribute("jobs",jobSeeker.getJobs());
		return "/jobseeker/applied-jobs";
	}

	@RequestMapping(value = "/applysuccess", method = RequestMethod.GET)
	public String applySuccess(@ModelAttribute Job job) {
		return "/jobseeker/apply-success";
	}
	
	@RequestMapping(value = "/apply/{jobId}", method = RequestMethod.GET)
	public String apply(@PathVariable Long jobId, Authentication authentication, RedirectAttributes redirectAttributes) {
		JobSeeker jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
		Job job = jobService.getJobById(jobId);
		jobSeeker.getJobs().add(job);
		jobSeekerService.saveJobSeeker(jobSeeker);
		redirectAttributes.addFlashAttribute(job);
		return "redirect:/jobseeker/applysuccess";
	}

}
