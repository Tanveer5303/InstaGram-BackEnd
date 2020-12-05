package com.bilal.instaclonebackend.controller;

import com.bilal.instaclonebackend.model.User;
import com.bilal.instaclonebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/user")
class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public @ResponseBody
    String addNewUser(User user) {
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
