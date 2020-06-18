package com.genuinehire.service.impl;

import com.genuinehire.domain.JobSeeker;
import com.genuinehire.domain.User;
import com.genuinehire.repository.AdminRepository;
import com.genuinehire.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminimplServiceimpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<JobSeeker> getUserByUsername(String username) {

        return adminRepository.findAllUsers(username);
    }
}
