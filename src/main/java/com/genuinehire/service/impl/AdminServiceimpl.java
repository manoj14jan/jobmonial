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
public class AdminServiceimpl implements AdminService {

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
<<<<<<< Updated upstream:src/main/java/com/genuinehire/service/impl/AdminServiceimpl.java

    @Override
    public List<JobSeeker> getUserByprofileTitleAndName(String profileTitle, String name) {

        return adminRepository.findAllUsersByprofileTitleAndName(name,profileTitle);

=======
    
    @Override
    public List<Employer> getEmployerByUsername(String username) {

        return adminRepository.findAllEmployeeByUsername(username);
>>>>>>> Stashed changes:src/main/java/com/genuinehire/service/impl/AdminimplServiceimpl.java
    }
}
