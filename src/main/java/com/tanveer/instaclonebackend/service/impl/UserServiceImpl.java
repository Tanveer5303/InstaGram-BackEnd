package com.tanveer.instaclonebackend.service.impl;

import com.tanveer.instaclonebackend.dto.UserDTO;
import  com.tanveer.instaclonebackend.model.User;
import  com.tanveer.instaclonebackend.repository.UserRepository;
import  com.tanveer.instaclonebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public UserDTO addUser(UserDTO userDTO) {

            User user = convertDTOtoEntity(userDTO);

            User usersaved =  userRepository.save(user);

            UserDTO userDTOReturned = convertEntityToDTO(usersaved);

        return userDTOReturned;
    }

    @Override
    public UserDTO updateUser(Long uId, UserDTO userDTO) {

         userRepository.findById(uId).orElseThrow(
                ()-> new RuntimeException("User not found")
        );
        User updateUser = convertDTOtoEntity(userDTO);
        updateUser.setUId(uId);
        User userSaved =  userRepository.save(updateUser);

        return convertEntityToDTO(userSaved);
    }


    @Override
    public UserDTO findUser(Long uId) {

       User user =  userRepository.findById(uId).orElseThrow(
               ()-> new RuntimeException("id not found")
       );
    UserDTO userDTO = convertEntityToDTO(user);
    return userDTO;
    }

    @Override
    public UserDTO deleteUser(long uId) {
        User usertobeDeleted = userRepository.findById(uId).orElseThrow(
                ()-> new RuntimeException("id not found")
        );

        userRepository.deleteById(uId);
        UserDTO userDTO = convertEntityToDTO(usertobeDeleted);
        return userDTO;
    }



    private UserDTO convertEntityToDTO(User user){
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .profile_pic_url(user.getProfile_pic_url())
                .userName(user.getUserName())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }
    private User convertDTOtoEntity(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .profile_pic_url(userDTO.getProfile_pic_url())
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .email(userDTO.getEmail())
                .build();
    }
}
