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
@Table(name = "reaction_tb")
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reactionId;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "uId"
    )
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "postId"
    )
    private Post post;

    private String reaction;
    private Instant time;

}
