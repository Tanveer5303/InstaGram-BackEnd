package com.bilal.instaclonebackend.service.impl;

import  com.bilal.instaclonebackend.entity.Comment;
import  com.bilal.instaclonebackend.repository.CommentRepository;
import  com.bilal.instaclonebackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public Comment addComment(Comment comment) {
        return null;
    }

    @Override
    public Comment findComment(int id) {
        return null;
    }
}
