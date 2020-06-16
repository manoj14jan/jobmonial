package com.genuinehire.service.impl;

import com.genuinehire.domain.Employer;
import com.genuinehire.repository.EmployerRepository;
import com.genuinehire.service.EmployerService;
import com.genuinehire.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    public Employer saveEmployer(Employer e){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(e.getUser().getPassword());
        e.getUser().setPassword(password);
        e.getUser().setRole(Role.ROLE_EMPLOYER.toString());
        e.getUser().setEnabled(1);
        return employerRepository.save(e);
    }

    @Override
    public Employer getEmployerByUsername(String name) {
        return null;
    }
}
