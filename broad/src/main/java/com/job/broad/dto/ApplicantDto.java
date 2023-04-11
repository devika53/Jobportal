package com.job.broad.dto;

import lombok.Data;

@Data
public class ApplicantDto {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String address;
    private String educationdetails;
    private Long roleId;
    private String skills;
    private Long userId;
}
