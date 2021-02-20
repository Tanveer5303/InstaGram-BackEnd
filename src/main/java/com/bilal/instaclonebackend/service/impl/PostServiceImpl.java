package com.bilal.instaclonebackend.service.impl;

import com.bilal.instaclonebackend.entity.Post;
import com.bilal.instaclonebackend.repository.PostRepository;
import com.bilal.instaclonebackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findPost(int id) {
        return postRepository.findById(id).get();
    }
}
