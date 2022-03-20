package com.tanveer.instaclonebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_tb")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String password;
    private String profile_pic_url;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE) //removed orphanRemoval
    private List<Post> posts;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Comment> comments ;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Reaction> reactions;

    }



