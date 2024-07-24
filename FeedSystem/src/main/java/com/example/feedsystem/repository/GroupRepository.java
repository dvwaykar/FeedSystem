package com.example.feedsystem.repository;

import com.example.feedsystem.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
