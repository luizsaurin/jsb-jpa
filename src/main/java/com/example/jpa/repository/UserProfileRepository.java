package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.UserProfileEntity;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
	
}
