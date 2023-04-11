package com.job.broad.services;

import com.job.broad.dto.JobDto;
import com.job.broad.entity.Job;
import com.job.broad.entity.Skills;
import com.job.broad.repository.JobRepository;
import com.job.broad.repository.SkillsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
//@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final SkillsRepository skillsRepository;

    @Autowired
    public JobService(JobRepository jobRepository, SkillsRepository skillsRepository) {
        this.jobRepository = jobRepository; this.skillsRepository = skillsRepository;
    }
    public String addNewJob(JobDto jobDto) {
        Job e = new Job();
        e.setTitle(jobDto.getTitle());
        e.setDescription(jobDto.getDescription());
        e.setStatus(jobDto.getStatus());
        Optional<Skills> skill = skillsRepository.findById(jobDto.getSkill_id()); // getting the skills id
        e.getSkills().add(skill.get()); //adding to the job
        jobRepository.save(e);
        return "Successfully saved the job details";
    }
// to list all the job details to admin
    public List<JobDto> listAllJobs() {
        List<Job> job = jobRepository.findAll();
        List<JobDto> jobDto = new ArrayList<>();
        job.forEach(jobs -> {
            JobDto jobObj = new JobDto();

            jobObj.setTitle(jobs.getTitle());
            jobObj.setDescription(jobs.getDescription());
            jobObj.setStatus(jobs.getStatus());
            jobDto.add(jobObj);
        });
        return jobDto;
    }
    public List<JobDto> searchJobs(String skill,Long status) {
        List<Job> job = jobRepository.findBySkillsSkillAndStatus(skill,status);
        List<JobDto> jobDto = new ArrayList<>();
        job.forEach(jobs -> {
            JobDto jobObj = new JobDto();

            jobObj.setTitle(jobs.getTitle());
            jobObj.setDescription(jobs.getDescription());
            jobObj.setStatus(jobs.getStatus());
            jobDto.add(jobObj);
        });
        return jobDto;
    }
}
