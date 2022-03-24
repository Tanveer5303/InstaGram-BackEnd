package com.tanveer.instaclonebackend.service;

import com.tanveer.instaclonebackend.dto.CommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    List<CommentDTO> getAllComments(Long uId, Long postId);

    CommentDTO addComment(Long uId, Long postId, CommentDTO commentDTO);

    CommentDTO findComment(Long uId, Long postId, long commentId);

    CommentDTO deleteComment(long commentId);


    CommentDTO updateComment(Long uId, Long postId, Long commentId, CommentDTO commentDTO);
}
