package com.tanveer.instaclonebackend.controller;

import com.tanveer.instaclonebackend.dto.PostDTO;
import com.tanveer.instaclonebackend.dto.UserDTO;
import com.tanveer.instaclonebackend.service.PostService;
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

    @PostMapping("/{uId}/add")
    public ResponseEntity<PostDTO> addPost(@PathVariable Long uId,@RequestBody PostDTO postDTO) {
        return new ResponseEntity<PostDTO>(postService.addPost(uId,postDTO),HttpStatus.OK);
    }

    @PutMapping("/{uId}/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable(value ="uId" ) Long uId,
                                              @PathVariable(value = "postId") Long postId,
                                              @RequestBody PostDTO postDTO){
        return new ResponseEntity<PostDTO>(postService.updatePost(uId,postId,postDTO),HttpStatus.OK);
    }


    @GetMapping("/all/{uId}")
    public List<PostDTO> getAllPost(@PathVariable Long uId ) {
        return postService.getAllPost(uId);
    }

    @GetMapping("/{uId}/{postId}")
    public ResponseEntity<PostDTO> findPost(@PathVariable(value = "uId")Long uId,
                                            @PathVariable(value = "postId") Long postId) {
        return new ResponseEntity<PostDTO>(postService.findPost(uId,postId), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDTO> deletePost(@PathVariable int postId){
        return new ResponseEntity<PostDTO>(postService.deletePost(postId),HttpStatus.OK);}
}
