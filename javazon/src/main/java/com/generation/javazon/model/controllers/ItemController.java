package com.generation.javazon.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javazon.model.dto.item.ItemDtoR;
import com.generation.javazon.model.dto.item.ItemDtoWFull;
import com.generation.javazon.model.dto.item.ItemDtoWNoReview;
import com.generation.javazon.model.dtoservices.ItemConverter;
import com.generation.javazon.model.entities.Item;
import com.generation.javazon.model.repositories.ItemRepository;

@RestController

public class ItemController {

    @Autowired
    ItemRepository repoI;
    @Autowired
    ItemConverter conv;
    
    @GetMapping("/items")
    public List<ItemDtoWNoReview> getAll() {
        return repoI.findAll()
        .stream()
        .map(e -> conv.ItemToDtoWNoDocuments(e))
        .toList();
    }
    
    @GetMapping("/items/full")
    public List<ItemDtoWFull> getAllItemsFull() {
        return  repoI.findAll()
        .stream()
        .map(e -> conv.ItemToDtoWFull(e))
        .toList();
    }
    
    @PostMapping("/items")
    public Item insertItem(@RequestBody ItemDtoR dto) {
        return repoI.save(conv.dtoRToItem(dto));
    }

    @GetMapping("/items/{id}")
    public ItemDtoWFull getMethodName(@PathVariable Integer id) {
        return conv.ItemToDtoWFull(repoI.findById(id).get());
    }
    
    @PutMapping("/items/{id}")
    public ItemDtoWNoReview updateItem(@RequestBody ItemDtoR dto,@PathVariable Integer id) {
        Item p = conv.dtoRToItem(dto);
        p.setId(id);
        return conv.ItemToDtoWNoDocuments(repoI.save(p));
    }

    @DeleteMapping("/items/{id}")
    public void  deleteItem(@PathVariable Integer id) {
         repoI.deleteById(id);
    }
}
