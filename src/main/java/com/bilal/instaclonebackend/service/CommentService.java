package com.bilal.instaclonebackend.service;

import com.bilal.instaclonebackend.dto.CommentDTO;
import  com.bilal.instaclonebackend.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    List<CommentDTO> getAllComments();

    CommentDTO addComment(Comment comment);

    CommentDTO findComment(long commentId);

    CommentDTO deleteComment(long commentId);


}
