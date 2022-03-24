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


    @PostMapping("/add/{uId}/{postId}")
    public ResponseEntity<CommentDTO> addComment(@PathVariable(value = "uId") Long uId,
                                                 @PathVariable(value = "postId") Long postId,
                                                 @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<CommentDTO>(commentService.addComment(uId,postId,commentDTO), HttpStatus.OK);
    }

    @PutMapping("{uId}/{postId}/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "uId") Long uId,
                                                    @PathVariable(value = "postId")Long postId,
                                                    @PathVariable(value = "commentId") Long commentId,
                                                    @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<CommentDTO>(commentService.updateComment(uId,postId,commentId,commentDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable Long commentId) {
        return new ResponseEntity<CommentDTO>(commentService.deleteComment(commentId),HttpStatus.OK);
    }

    @GetMapping("/{uId}/{postId}/all")  //we will check uId and postId exist and they are corelated
    public List<CommentDTO> getAllComment(@PathVariable(value = "uId") Long uId,  //getting comments by postid
                                          @PathVariable(value = "postId") Long postId) {
        return commentService.getAllComments(uId,postId);
    }

    @GetMapping("find/{uId}/{postId}/{commentId}")// we will compare the uId(Id) and postId(Id) then compare postId(Id) and commentId(Id)
    public ResponseEntity<CommentDTO> findComment(@PathVariable(value = "uId") Long uId,
                                                  @PathVariable(value = "postId") Long postId,
                                                  @PathVariable(value = "commentId") Long commentId) {
        return new ResponseEntity<CommentDTO>(commentService.findComment(uId,postId,commentId),HttpStatus.OK);
    }
}
