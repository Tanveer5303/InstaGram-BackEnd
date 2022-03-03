package com.bilal.instaclonebackend.service;

import com.bilal.instaclonebackend.dto.UserDTO;
import  com.bilal.instaclonebackend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO addUser(UserDTO userDTO);

    UserDTO findUser(Long uId);

    UserDTO deleteUser(long uId);
}
