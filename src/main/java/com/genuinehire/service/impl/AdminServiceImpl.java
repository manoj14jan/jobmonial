package com.genuinehire.service.impl;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.JobSeeker;
import com.genuinehire.domain.User;
import com.genuinehire.repository.AdminRepository;
import com.genuinehire.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<JobSeeker> getUserByUsername(String name) {

        return adminRepository.findAllUsersByUsername(name);
    }
    
    @Override
    public List<JobSeeker> getUserByprofileTitle(String profileTitle) {

        return adminRepository.findAllUsersByprofileTitle(profileTitle);
    }

    @Override
    public List<JobSeeker> getUserByprofileTitleAndName(String profileTitle, String name) {

        return adminRepository.findAllUsersByprofileTitleAndName(name,profileTitle);
    }
}
