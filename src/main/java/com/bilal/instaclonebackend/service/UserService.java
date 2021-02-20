package com.bilal.instaclonebackend.service;

import  com.bilal.instaclonebackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User addUser(User user);

    User findUser(int id);
}
