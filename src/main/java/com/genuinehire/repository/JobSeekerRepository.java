package com.genuinehire.repository;

import com.genuinehire.domain.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.genuinehire.domain.JobSeeker;

import java.util.List;

@Repository
public interface JobSeekerRepository extends CrudRepository<JobSeeker, Long>{
	public JobSeeker findByUserUsername(String username);
	public List<JobSeeker> findBySkills(String skills);
}
