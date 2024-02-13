package com.generation.javazon.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javazon.model.entities.DeliveryItem;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Integer> {

}
