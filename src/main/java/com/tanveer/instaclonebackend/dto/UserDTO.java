package com.tanveer.instaclonebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
//add password phonenumber , email
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String password;
    private String profile_pic_url;                    //profilepic

    //Do we have to add foreign keys to user also?


}
