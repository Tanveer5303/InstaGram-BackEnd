package com.tanveer.instaclonebackend.controller;

import com.tanveer.instaclonebackend.dto.CommentDTO;
import com.tanveer.instaclonebackend.dto.PostDTO;
import com.tanveer.instaclonebackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;


    @PostMapping("/add")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<CommentDTO>(commentService.addComment(commentDTO), HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long commentId, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<CommentDTO>(commentService.updateComment(commentId,commentDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable Long commentId) {
        return new ResponseEntity<CommentDTO>(commentService.deleteComment(commentId),HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<CommentDTO> getAllComment() {
        return commentService.getAllComments();
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDTO> findComment(@PathVariable Long commentId) {
        return new ResponseEntity<CommentDTO>(commentService.findComment(commentId),HttpStatus.OK);
    }
}
