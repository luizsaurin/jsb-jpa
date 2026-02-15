package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
	
}
