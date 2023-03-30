package com.job.broad.dto;

import lombok.Data;

@Data
public class JobDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthdate;
}
