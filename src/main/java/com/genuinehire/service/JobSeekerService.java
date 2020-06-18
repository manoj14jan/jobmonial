package com.genuinehire.service;

import com.genuinehire.domain.JobSeeker;

import java.util.List;

public interface JobSeekerService {

	JobSeeker saveJobSeeker(JobSeeker jobSeeker);
	JobSeeker getJobSeekerByUsername(String username);
    List<JobSeeker> getAllJobSeekers();
    JobSeeker getJobSeekerById(Long id);
}
