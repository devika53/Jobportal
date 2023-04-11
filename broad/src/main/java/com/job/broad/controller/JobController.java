package com.job.broad.controller;

import com.job.broad.dto.EmployerDto;
import com.job.broad.dto.JobDto;
import com.job.broad.services.EmployerService;
import com.job.broad.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/listJobs")
    public List<JobDto> getJobs(){
        List<JobDto> job=null;
        job=jobService.listAllJobs();
        return job;
    }

    @GetMapping("/job/search/{keyword}")
    public @ResponseBody
    ResponseEntity<List<JobDto>> getJobBySkillName(@PathVariable("keyword") String keyword) {
        return new ResponseEntity(jobService.searchJobs(keyword,1L), HttpStatus.OK);
    }
}

