package com.job.broad.controller;

import com.job.broad.dto.EmployerDto;
import com.job.broad.dto.JobDto;
import com.job.broad.services.EmployerService;
import com.job.broad.services.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1")
public class JobController {
    private final JobService jobService;
    public JobController(JobService jobService){
            this.jobService=jobService;
        }
        @PostMapping("/addJob")
        public String addJob(@RequestBody JobDto jobDto){
            jobService.addNewJob(jobDto);
            return "Successfully saved the job details";
        }
}

