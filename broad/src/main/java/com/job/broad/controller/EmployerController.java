package com.job.broad.controller;

import com.job.broad.dto.EmployerDto;
import com.job.broad.services.EmployerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }
    @PostMapping("/addEmployer")
    public String addEmployer(@RequestBody EmployerDto employerDto){
        employerService.addNewEmployer(employerDto);
        return "Successfully saved the employee details";
    }
}
