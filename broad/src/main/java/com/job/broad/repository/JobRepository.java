package com.job.broad.repository;

import com.job.broad.entity.Employer;
import com.job.broad.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    List<Job> findBySkillsSkillAndStatus(String skill,Long Status);
}
