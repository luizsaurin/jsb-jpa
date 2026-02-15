package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	
}
