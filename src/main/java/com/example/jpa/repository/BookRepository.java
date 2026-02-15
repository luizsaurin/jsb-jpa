package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
	
}
