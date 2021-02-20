package com.bilal.instaclonebackend.repository;

import  com.bilal.instaclonebackend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
