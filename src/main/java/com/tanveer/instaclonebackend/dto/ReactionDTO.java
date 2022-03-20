package com.tanveer.instaclonebackend.dto;

import com.tanveer.instaclonebackend.model.Post;
import com.tanveer.instaclonebackend.model.User;
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
