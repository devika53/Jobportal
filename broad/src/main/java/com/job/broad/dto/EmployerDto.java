package com.job.broad.dto;

import lombok.Data;

@Data
public class EmployerDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String birthdate;
    private Long userId;
}
