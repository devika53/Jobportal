package com.job.broad.services;

import com.job.broad.dto.JobDto;
import com.job.broad.entity.Job;
import com.job.broad.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public String addNewJob(JobDto jobDto) {
        Job e = new Job();
        e.setFirstName(jobDto.getFirstName());
        e.setLastName(jobDto.getLastName());
        e.setEmail(jobDto.getEmail());
        e.setPassword(jobDto.getPassword());
        e.setBirthdate(jobDto.getBirthdate());
        jobRepository.save(e);
        return "Successfully saved the employee details";
    }
}
