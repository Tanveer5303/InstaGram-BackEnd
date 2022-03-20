package com.tanveer.instaclonebackend.service;

import com.tanveer.instaclonebackend.dto.UserDTO;
import  com.tanveer.instaclonebackend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO addUser(UserDTO userDTO);

    UserDTO updateUser(Long uId, UserDTO userDTO);

    UserDTO findUser(Long uId);

    UserDTO deleteUser(long uId);
}
