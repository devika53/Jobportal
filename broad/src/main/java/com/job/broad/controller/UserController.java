package com.job.broad.controller;

import com.job.broad.dto.UserDto;
import com.job.broad.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home() {return "Welcome To JobPortal";
    }

    @PostMapping("/saveuser")
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }
}
