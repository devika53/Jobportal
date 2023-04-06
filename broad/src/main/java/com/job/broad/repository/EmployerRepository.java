package com.job.broad.repository;

import com.job.broad.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
    Employer findByEmail(String email);
}
