package com.bilal.instaclonebackend.controller;

import com.bilal.instaclonebackend.dto.PostDTO;
import  com.bilal.instaclonebackend.model.Post;
import com.bilal.instaclonebackend.service.PostService;
import  com.bilal.instaclonebackend.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<PostDTO>(postService.addPost(postDTO),HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostDTO> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> findPost(@PathVariable int postId) {
        return new ResponseEntity<PostDTO>(postService.findPost(postId), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDTO> deletePost(@PathVariable int postId){
        return new ResponseEntity<PostDTO>(postService.deletePost(postId),HttpStatus.OK);}
}
