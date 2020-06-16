package com.genuinehire.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.genuinehire.domain.JobSeeker;

@Repository
public interface JobSeekerRepository extends CrudRepository<JobSeeker, Long>{
	public JobSeeker findByUserUsername(String username);
}
