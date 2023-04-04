package com.job.broad.dto;

import lombok.Data;

@Data
public class JobDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Long skill_id;
}
