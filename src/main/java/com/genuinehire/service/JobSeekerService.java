package com.genuinehire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.repository.JobSeekerRepository;

import java.util.List;

@Service
public class JobSeekerService {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	public JobSeeker saveJobSeeker(JobSeeker jobSeeker) {
		if(jobSeeker.getStatus() == null || jobSeeker.getStatus().equalsIgnoreCase("")) {
			jobSeeker.setStatus("seeking");
		}
		return jobSeekerRepository.save(jobSeeker);
	}
	
	public JobSeeker getJobSeekerByUsername(String username){
		return jobSeekerRepository.findByUserUsername(username);
	}

    public List<JobSeeker> getAllJobSeekers() {
		return (List<JobSeeker>)jobSeekerRepository.findAll();
    }

    public JobSeeker getJobSeekerById(Long id) {
		return jobSeekerRepository.findOne(id);
    }
}
