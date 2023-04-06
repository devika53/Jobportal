package com.job.broad.controller;

import com.job.broad.dto.ApplicantDto;
import com.job.broad.services.ApplicantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class ApplicantController {
    private final ApplicantService applicantService;
    public ApplicantController(ApplicantService applicationService){this.applicantService=applicationService;}

    @PostMapping("/register")
    public void createApplicant(@RequestBody ApplicantDto applicantDto){
        applicantService.registerApplicant(applicantDto);
    }

}
