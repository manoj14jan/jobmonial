package com.genuinehire.service.impl;

import com.genuinehire.domain.Job;
import com.genuinehire.repository.JobRepository;
import com.genuinehire.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }
}
