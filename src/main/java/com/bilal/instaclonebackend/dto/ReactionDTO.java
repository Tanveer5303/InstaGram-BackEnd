package com.bilal.instaclonebackend.dto;

import com.bilal.instaclonebackend.model.Post;
import com.bilal.instaclonebackend.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReactionDTO {
    private String Reactor ;     //username who reacted
    private Long PostId;           //post_image change this to post_id??????
    private Long uId;
    private String Reaction;
    private Instant Time;

    private User user;                //These are the
    private Post post;                     //Foreign keys

}
