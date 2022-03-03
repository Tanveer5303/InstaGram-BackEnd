package com.bilal.instaclonebackend.controller;

import com.bilal.instaclonebackend.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/user")
    public UserDTO getDemoUser(){
        return new UserDTO();
    }
}
