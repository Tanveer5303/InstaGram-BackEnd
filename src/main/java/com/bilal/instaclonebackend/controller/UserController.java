package com.bilal.instaclonebackend.controller;


import  com.bilal.instaclonebackend.entity.User;
import  com.bilal.instaclonebackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("add")
    public User addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("find/{uid}")
    public User findUser(@PathVariable int uid) {
        return userServiceImpl.findUser(uid);
    }


}
