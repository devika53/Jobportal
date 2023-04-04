package com.job.broad.services;

import com.job.broad.dto.EmployerDto;
import com.job.broad.entity.Employer;
import com.job.broad.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }
    public String addNewEmployer(EmployerDto employerDto) {
        Employer e = new Employer();
        e.setFirstname(employerDto.getFirstname());
        e.setLastname(employerDto.getLastname());
        e.setEmail(employerDto.getEmail());
        e.setPassword(employerDto.getPassword());
        e.setBirthdate(employerDto.getBirthdate());
        employerRepository.save(e);
        return "Successfully saved the employee details";
    }
}
