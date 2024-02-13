package com.generation.javazon.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javazon.model.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
