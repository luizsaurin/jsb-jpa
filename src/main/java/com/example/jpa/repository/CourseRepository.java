package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	
}
