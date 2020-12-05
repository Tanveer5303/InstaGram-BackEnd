package com.bilal.instaclonebackend.repository;

import com.bilal.instaclonebackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
