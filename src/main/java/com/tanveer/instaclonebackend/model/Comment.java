package com.tanveer.instaclonebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "comment_tb")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "user_id" ,
            referencedColumnName = "uId"
    )
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "postId"
    )
    private Post post;

    private String comment;
    private Instant time;


    }

