package com.tanveer.instaclonebackend.dto;

import com.tanveer.instaclonebackend.model.Post;
import com.tanveer.instaclonebackend.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CommentDTO {

    private String comment;
    private Instant time;
    private Long uId;
    private Long PostId;            //post image

    private User user;         //these are the
    private Post post;              //Foreign Key
}
