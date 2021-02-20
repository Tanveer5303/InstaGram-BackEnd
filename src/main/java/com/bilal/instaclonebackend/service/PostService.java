package com.bilal.instaclonebackend.service;

import  com.bilal.instaclonebackend.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> getAllPost();

    Post addPost(Post post);

    Post findPost(int id);
}
