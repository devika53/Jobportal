package com.job.broad.services;

import com.job.broad.dto.EmployerDto;
import com.job.broad.entity.Employer;
import com.job.broad.repository.EmployerRepository;
import com.job.broad.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final UserRepository userRepository;

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
