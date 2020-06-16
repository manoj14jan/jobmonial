package com.genuinehire.service.impl;

import com.genuinehire.domain.Employer;
import com.genuinehire.repository.EmployerRepository;
import com.genuinehire.repository.UserRepository;
import com.genuinehire.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private UserRepository userRepository;

    public Employer saveEmployer(Employer e){
        return employerRepository.save(e);
    }

    @Override
    public Employer getEmployerByUserUsername(String name) {
        return employerRepository.getEmployerByUserUsername(name);
    }
}
