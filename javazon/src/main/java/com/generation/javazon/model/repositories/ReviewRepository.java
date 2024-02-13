package com.generation.javazon.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javazon.model.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
