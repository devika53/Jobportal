package com.job.broad.controller;

import com.job.broad.dto.SkillsDto;
import com.job.broad.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class SkillsController {
    private final SkillService skillService;
    @Autowired
    public SkillsController(SkillService skillService){
        this.skillService=skillService;
    }

    @PostMapping("/addSkills")
    public void createSkills(@RequestBody SkillsDto skillsDto){
        skillService.createNewSkills(skillsDto);
    }
}
