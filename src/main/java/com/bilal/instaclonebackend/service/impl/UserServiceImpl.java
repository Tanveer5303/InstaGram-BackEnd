package com.bilal.instaclonebackend.service.impl;

import  com.bilal.instaclonebackend.entity.User;
import  com.bilal.instaclonebackend.repository.UserRepository;
import  com.bilal.instaclonebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUser(int id) {
        return  userRepository.findById(id).get();

    }
}
