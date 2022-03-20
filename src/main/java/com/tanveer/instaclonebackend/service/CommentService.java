package com.tanveer.instaclonebackend.service;

import com.tanveer.instaclonebackend.dto.CommentDTO;
import  com.tanveer.instaclonebackend.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    List<CommentDTO> getAllComments();

    CommentDTO addComment(CommentDTO commentDTO);

    CommentDTO findComment(long commentId);

    CommentDTO deleteComment(long commentId);


    CommentDTO updateComment(Long commentId, CommentDTO commentDTO);
}
