package com.genuinehire.service;

import com.genuinehire.domain.JobSeeker;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public List<JobSeeker> getUserByUsername(String username);
    public List<JobSeeker> getUserByprofileTitle(String profileTitle);
    public List<JobSeeker> getUserByprofileTitleAndName(String profileTitle,String name);
}
