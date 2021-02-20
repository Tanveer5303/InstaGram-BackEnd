package com.bilal.instaclonebackend.repository;

import  com.bilal.instaclonebackend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
