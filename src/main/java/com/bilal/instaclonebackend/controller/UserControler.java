package com.bilal.instaclonebackend.controller;

import com.bilal.instaclonebackend.model.User;
import com.bilal.instaclonebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping()
    public User addUser(@RequestBody User user) {
        User save = userRepository.save(user);
        return save;
    }

    @GetMapping()
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
