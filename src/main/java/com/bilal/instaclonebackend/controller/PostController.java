package com.bilal.instaclonebackend.controller;

import  com.bilal.instaclonebackend.entity.Post;
import  com.bilal.instaclonebackend.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServiceImpl postServiceimpl;

    @PostMapping("addPost")
    public Post addPost(@RequestBody Post post) {
        return postServiceimpl.addPost(post);
    }

    @GetMapping("/allPost")
    public List<Post> getAllPost() {
        return postServiceimpl.getAllPost();
    }

    @GetMapping("find/{post_id}")
    public Post findPost(@PathVariable int post_id) {
        return postServiceimpl.findPost(post_id);
    }

}
