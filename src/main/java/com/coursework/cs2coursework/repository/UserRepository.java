package com.coursework.cs2coursework.repository;

import com.coursework.cs2coursework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}