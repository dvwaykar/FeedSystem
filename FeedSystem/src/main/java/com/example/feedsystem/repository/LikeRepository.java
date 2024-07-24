package com.example.feedsystem.repository;

import com.example.feedsystem.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
