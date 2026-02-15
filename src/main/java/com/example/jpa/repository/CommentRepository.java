package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
	
}
