package com.job.broad.repository;

import com.job.broad.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
        Applicant findByName(String name);

}

