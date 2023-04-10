package com.job.broad.dto;

import com.job.broad.entity.Role;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Long roleId;
//    private Role role;
}
