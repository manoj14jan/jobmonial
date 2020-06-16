package com.genuinehire.service.impl;

import com.genuinehire.domain.Employer;
import com.genuinehire.repository.EmployerRepository;
import com.genuinehire.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    public void save(Employer e){
        employerRepository.save(e);
    }
}
