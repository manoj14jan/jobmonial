package com.genuinehire.controller;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.domain.Review;
import com.genuinehire.service.JobSeekerService;
import com.genuinehire.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {

    @Autowired
    private JobSeekerService jobSeekerService;
    @Autowired
    private ReviewService reviewService ;

    @RequestMapping(value = "jobseeker/review", method = RequestMethod.GET)
    public String Reeview_form(@ModelAttribute Review review, Authentication authentication) {
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());

        return "jobseeker/review-form";
    }

    @RequestMapping(value = "jobseeker/review", method = RequestMethod.POST)
    public String save_form(@ModelAttribute Review review, Authentication authentication) {
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerByUsername(authentication.getName());
        reviewService.saveReview(review);


        return "redirect:/jobseeker/home";
    }


}
