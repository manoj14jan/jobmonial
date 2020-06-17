package com.genuinehire.service;

import com.genuinehire.domain.Employer;

public interface EmployerService {
    Employer saveEmployer(Employer e);
    Employer getEmployerByUserUsername(String name);
    void delete(Employer employer);
    void updateEmployer(Employer employer);
}
