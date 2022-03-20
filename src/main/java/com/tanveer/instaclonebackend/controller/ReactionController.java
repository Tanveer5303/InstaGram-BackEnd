package com.tanveer.instaclonebackend.controller;

import com.tanveer.instaclonebackend.dto.CommentDTO;
import com.tanveer.instaclonebackend.dto.ReactionDTO;
import com.tanveer.instaclonebackend.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reaction")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @PostMapping("/add")
    public ResponseEntity<ReactionDTO> addreaction(@RequestBody ReactionDTO reactionDTO) {
        return new ResponseEntity<ReactionDTO>(reactionService.addReaction(reactionDTO), HttpStatus.OK);
    }

    @PutMapping("/{reactionId}")
    public ResponseEntity<ReactionDTO> updateReaction(@PathVariable Long reactionId, @RequestBody ReactionDTO reactionDTO){
        return new ResponseEntity<ReactionDTO>(reactionService.updateReaction(reactionId,reactionDTO),HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ReactionDTO> getAllReaction() {
        return reactionService.getAllReaction();
    }

    @GetMapping("/{reactionId}")
    public ResponseEntity<ReactionDTO> findReaction(@PathVariable int reactionId) {
        return new ResponseEntity<ReactionDTO>(reactionService.findReaction(reactionId), HttpStatus.OK);
    }

    @DeleteMapping("/{reactionId}")
    public ResponseEntity<ReactionDTO> deleteReaction(@PathVariable int reactionId){
        return new ResponseEntity<ReactionDTO>(reactionService.deleteReaction(reactionId),HttpStatus.OK);}
}
