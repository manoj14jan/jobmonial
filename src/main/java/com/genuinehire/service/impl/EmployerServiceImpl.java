package com.genuinehire.service.impl;

import com.genuinehire.domain.Employer;
import com.genuinehire.domain.User;
import com.genuinehire.repository.EmployerRepository;
import com.genuinehire.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    public Employer saveEmployer(Employer e){
        return employerRepository.save(e);
    }

    @Override
    public Employer getEmployerByUserUsername(String name) {
        return employerRepository.getEmployerByUserUsername(name);
    }

    @Override
    public void delete(Employer employer) {
        employerRepository.delete(employer);
    }

    @Override
    public void updateEmployer(Employer employer) {
        employerRepository.save(employer);
    }
}
