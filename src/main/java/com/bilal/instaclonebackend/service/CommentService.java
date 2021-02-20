package com.bilal.instaclonebackend.service;

import  com.bilal.instaclonebackend.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    List<Comment> getAllComments();

    Comment addComment(Comment comment);

    Comment findComment(int id);

}
