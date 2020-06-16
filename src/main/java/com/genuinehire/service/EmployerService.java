package com.genuinehire.service;

import com.genuinehire.domain.Employer;

public interface EmployerService {
    Employer saveEmployer(Employer e);
    Employer getEmployerByUsername(String name);
}
