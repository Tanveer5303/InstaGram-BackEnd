package com.bilal.instaclonebackend.service.impl;

import com.bilal.instaclonebackend.dto.CommentDTO;
import com.bilal.instaclonebackend.dto.UserDTO;
import  com.bilal.instaclonebackend.model.Comment;
import com.bilal.instaclonebackend.model.User;
import  com.bilal.instaclonebackend.repository.CommentRepository;
import  com.bilal.instaclonebackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentDTO> getAllComments() {

        return commentRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO addComment(Comment comment) {

        Comment commentSaved = commentRepository.save(comment);
        CommentDTO commentDTO = convertEntityToDTO(commentSaved);
        return commentDTO;
    }

    @Override
    public CommentDTO findComment(long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new RuntimeException("Comment not found")
        );
        CommentDTO commentDTO = convertEntityToDTO(comment);

        return commentDTO;
    }

    @Override
    public CommentDTO deleteComment(long commentId) {
        Comment commenttobeDeleted = commentRepository.findById(commentId).orElseThrow(
                ()-> new RuntimeException("comment not found")
        );
        commentRepository.delete(commenttobeDeleted);

        CommentDTO commentDTO = convertEntityToDTO(commenttobeDeleted);
        return commentDTO;
    }

    private CommentDTO convertEntityToDTO(Comment comment){
        return CommentDTO.builder()
                .commenter(comment.getUser().getUserName())
                .comment(comment.getComment())
                .time(comment.getTime())
                .build();
}
}
