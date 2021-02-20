package com.bilal.instaclonebackend.repository;

import  com.bilal.instaclonebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
