package com.genuinehire.controller;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.Job;
import com.genuinehire.scurity.CustomUserDetails;
import com.genuinehire.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.genuinehire.service.EmployerService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(@ModelAttribute Employer employer, Authentication authentication, Model m) {
        employer = employerService.getEmployerByUserUsername(authentication.getName());

        if (employer == null) {
            return "employer/employer-form";
        }
        m.addAttribute("jobs", jobService.getEmployerJobs(employer));
        return "/employer/employer-home";
    }

    @RequestMapping(value = "/profile/save")
    public String saveProfile(@Valid @ModelAttribute("employer") Employer employer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "employer/employer-form";
        }
        if (authentication != null) {
            CustomUserDetails o = (CustomUserDetails) authentication.getPrincipal();
            employer.setUser(o.getUser());
            employerService.saveEmployer(employer);
        }
        return "redirect:/employer/profile";
    }


    @RequestMapping({"/", "/profile"})
    public String homes(Model m, Authentication authentication) {
        Employer employer = employerService.getEmployerByUserUsername(authentication.getName());
        m.addAttribute("employer", employer);
        return "/employer/employer-profile";
    }


    @RequestMapping(value = "/profile/update", method = RequestMethod.GET)
    public String updateEmployerProfile(Authentication authentication, Model m) {
        Employer employer = employerService.getEmployerByUserUsername(authentication.getName());
        m.addAttribute("employer", employer);
        return "/employer/employer-profile-update";
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.POST)
    public String updateEmployerProfile(@Valid @ModelAttribute("employer") Employer employer, BindingResult
            bindingResult, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "/employer/employer-profile-update";
        }
        employerService.updateEmployer(employer);
        return "redirect:/employer/profile";
    }

    @RequestMapping(value = "/profile/delete", method = RequestMethod.GET)
    public String deleteEmployerProfile(Authentication authentication) {
        Employer employer = employerService.getEmployerByUserUsername(authentication.getName());
        employerService.delete(employer);
        return "redirect:/logout";
    }

	@RequestMapping(value = "/job/post", method = RequestMethod.GET)
	public String postJob(@ModelAttribute("job") Job job) {
		return "/employer/employer-job-post";
	}

    @RequestMapping(value = "/job/post", method = RequestMethod.POST)
    public String saveJob(@Valid @ModelAttribute("job") Job job, BindingResult bindingResult, Authentication authentication) {
        Employer employer = employerService.getEmployerByUserUsername(authentication.getName());
        if(bindingResult.hasErrors()){
            return "/employer/employer-job-post";
        }
        job.setEmployer(employer);
        jobService.save(job);
        return "/employer/employer-jobs";
    }


    @RequestMapping(value = "/job/update", method = RequestMethod.GET)
    public String updateJob() {
        return "employer/employer-job-update";
    }
}
