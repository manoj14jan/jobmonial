package com.genuinehire.controller;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.Job;
import com.genuinehire.domain.JobSeeker;
import com.genuinehire.scurity.CustomUserDetails;
import com.genuinehire.service.JobSeekerService;
import com.genuinehire.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.genuinehire.service.EmployerService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobSeekerService jobSeekerService;

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

    @RequestMapping(value = "/job/{id}/edit", method = RequestMethod.GET)
    public String editJob(@PathVariable("id") Long id, Model m) {
        m.addAttribute("job", jobService.getJobById(id));
        return "/employer/employer-job-update";
    }

    @RequestMapping(value = "/job/update", method = RequestMethod.POST)
    public String updateJob(@ModelAttribute("job") Job job, Model m) {
        Employer employer = employerService.getEmployerById(job.getEmployer().getId());
        job.setEmployer(employer);
        jobService.save(job);
        return "redirect:/employer/home";
    }

    @RequestMapping(value = "/job/{id}/delete", method = RequestMethod.GET)
    public String deleteJob(@PathVariable("id") Long id, Model m) {
        Job job = jobService.getJobById(id);
        job.setEmployer(null);
        jobService.delete(job);
        return "redirect:/employer/home";
    }

    @RequestMapping(value = "/hire", method = RequestMethod.GET)
    public String hireEmployee(Model m) {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers().stream().filter(x-> x.getStatus() != null && x.getStatus().equalsIgnoreCase("seeking")).collect(Collectors.toList());
        m.addAttribute("jobseekers", jobSeekers);
        return "/employer/employer-hire";
    }

    @RequestMapping(value = "/hire/{id}/save", method = RequestMethod.GET)
    public String saveEmployer(Model m, @PathVariable("id") Long id, Authentication authentication) {
        Employer employer = employerService.getEmployerByUserUsername(authentication.getName());
        m.addAttribute("jobs", jobService.getEmployerJobs(employer).stream().filter(x -> x != null && x.getStatus().equals("available")).collect(Collectors.toList()));
        m.addAttribute("jobSeekerId", id);
        return "/employer/employer-hire-jobselect";
    }

    @RequestMapping(value = "/hire/{id}/savedata", method = RequestMethod.POST)
    public String saveEmployerData(@RequestParam("jobSeekerId") Long jobSeekerId,Model m, @PathVariable("id") Long jobId) {
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerById(jobSeekerId);
        jobSeeker.setStatus("hired");
        jobSeekerService.saveJobSeeker(jobSeeker);

        Job job = jobService.getJobById(jobId);
        job.setJobSeeker(jobSeeker);
        job.setStatus("closed");

        jobService.save(job);
        return "redirect:/employer/hired";
    }

    @RequestMapping(value = "/hired", method = RequestMethod.GET)
    public String showEmployees(Model m,Authentication authentication) {
        Employer employer = employerService.getEmployerByUserUsername(authentication.getName());
        m.addAttribute("jobs", jobService.getEmployerJobs(employer).stream().filter(x->x.getJobSeeker() != null).collect(Collectors.toList()));
        return "/employer/employer-hired";
    }
}
