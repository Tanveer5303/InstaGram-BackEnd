package com.bilal.instaclonebackend.controller;


import com.bilal.instaclonebackend.dto.UserDTO;
import  com.bilal.instaclonebackend.model.User;
import com.bilal.instaclonebackend.service.UserService;
import  com.bilal.instaclonebackend.service.impl.UserServiceImpl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<UserDTO>(userService.addUser(userDTO),HttpStatus.OK);
    }

   @DeleteMapping("/{uId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long uId) {
        return new ResponseEntity<UserDTO>(userService.deleteUser(uId),HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{uId}")
    public ResponseEntity<UserDTO> findUser(@PathVariable Long uId) {
        return new ResponseEntity<UserDTO>(userService.findUser(uId),HttpStatus.OK);
    }


}
