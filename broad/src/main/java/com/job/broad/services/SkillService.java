package com.job.broad.services;

import com.job.broad.dto.SkillsDto;
import com.job.broad.entity.Skills;
import com.job.broad.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    private final SkillsRepository skillsRepository;
    @Autowired
    public SkillService(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public Skills createNewSkills(SkillsDto skillsDto) {
        Skills skill = new Skills();
        skill.setSkill(skillsDto.getSkill());
        skillsRepository.save(skill);
        return skill;
    }
}
