package com.genuinehire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.repository.JobSeekerRepository;
import com.genuinehire.util.Role;

@Service
public class JobSeekerService {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	public JobSeeker saveJobSeeker(JobSeeker jobSeeker) {
		return jobSeekerRepository.save(jobSeeker);
	}
	
	public JobSeeker getJobSeekerByUsername(String username){
		return jobSeekerRepository.findByUserUsername(username);
	}

}
