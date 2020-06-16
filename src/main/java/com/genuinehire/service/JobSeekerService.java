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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode(jobSeeker.getUser().getPassword());
		jobSeeker.getUser().setPassword(password);
		jobSeeker.getUser().setRole(Role.ROLE_JOBSEEKER.toString());
		jobSeeker.getUser().setEnabled(1);
		return jobSeekerRepository.save(jobSeeker);
	}
	
	public JobSeeker getJobSeekerByUsername(String username){
		return jobSeekerRepository.findByUserUsername(username);
	}

}
