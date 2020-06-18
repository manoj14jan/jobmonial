package com.genuinehire.service;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.domain.Employer;


import java.util.List;

public interface AdminService {
    public List<JobSeeker> getUserByUsername(String username);
    public List<JobSeeker> getUserByprofileTitle(String profileTitle);
    public List<JobSeeker>getUserByprofileTitleAndName(String profileTitle,String name);
}
