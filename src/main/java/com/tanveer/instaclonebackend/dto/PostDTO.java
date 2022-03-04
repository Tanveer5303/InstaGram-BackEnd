package com.bilal.instaclonebackend.dto;

import com.bilal.instaclonebackend.model.Comment;
import com.bilal.instaclonebackend.model.Reaction;
import com.bilal.instaclonebackend.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private String username;       //user
    private Long uId;
    //do need to add reaction id in this because there are too many reactions ?
    private String description;    //ADD PRIVATE LONG USER ID
    private String image_url;
    private Instant time;

    private User user;                          //these are
    private List<Reaction> reactions;              //the
    private List<Comment> comments;                   //Foreign keys


}
