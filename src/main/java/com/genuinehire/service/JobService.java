package com.genuinehire.service;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.Job;

import java.util.List;

public interface JobService {
    Job save(Job job);
    List<Job> getAll();
    List<Job> getEmployerJobs(Employer employer);
    Job getJobById(Long id);
    void delete(Job job);
    public List<Job> getJobBySkills(String skills);
}
