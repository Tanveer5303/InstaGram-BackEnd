package com.bilal.instaclonebackend.service;

import com.bilal.instaclonebackend.dto.PostDTO;
import  com.bilal.instaclonebackend.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<PostDTO> getAllPost();

    PostDTO addPost(PostDTO postDTO);

    PostDTO findPost(long postId);

    PostDTO deletePost(long postId);
}
