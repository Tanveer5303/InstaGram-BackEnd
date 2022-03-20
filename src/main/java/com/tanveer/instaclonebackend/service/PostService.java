package com.tanveer.instaclonebackend.service;

import com.tanveer.instaclonebackend.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<PostDTO> getAllPost();

    PostDTO addPost(Long uId, PostDTO postDTO);

    PostDTO findPost(long postId);

    PostDTO deletePost(long postId);

    PostDTO updatePost(Long postId, PostDTO postDTO);
}
