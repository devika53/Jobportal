package com.job.broad.controller;

import com.job.broad.dto.RoleDto;
import com.job.broad.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping("/role")
    public void createRole(@RequestBody RoleDto roleDto){
        System.out.println("rolecreation");
        roleService.addRoles(roleDto);
    }

}
