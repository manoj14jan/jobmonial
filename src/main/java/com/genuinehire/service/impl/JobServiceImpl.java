package com.genuinehire.service.impl;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.Job;
import com.genuinehire.repository.JobRepository;
import com.genuinehire.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.Predicate;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAll() {
        return (List<Job>) jobRepository.findAll();
    }

    @Override
    public List<Job> getEmployerJobs(Employer employer) {
        return jobRepository.findAllByEmployerId(employer.getId());
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findOne(id);
    }

    @Override
    public void delete(Job job) {
        jobRepository.delete(job);
    }
}
