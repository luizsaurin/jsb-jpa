package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
}
