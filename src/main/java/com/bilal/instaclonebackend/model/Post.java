package com.bilal.instaclonebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "post_tb")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private String description;
    private String image_url;
    private Instant time;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(
            name="user_id",
            referencedColumnName = "uId"
    )
    private User user; // HAVE TO KEEP This in dto

    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Reaction> reactions;   // HAVE TO KEEP This in dto

    @OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private List<Comment> comments;    // HAVE TO KEEP This in dto


}
