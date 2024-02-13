package com.generation.javazon.model.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.javazon.model.dto.review.ReviewDtoRpost;
import com.generation.javazon.model.dto.review.ReviewDtoRput;
import com.generation.javazon.model.dto.review.ReviewWItem;
import com.generation.javazon.model.dto.review.ReviewWNoItem;
import com.generation.javazon.model.dtoservices.ReviewConverter;
import com.generation.javazon.model.entities.Review;
import com.generation.javazon.model.repositories.ReviewRepository;

@RestController
@CrossOrigin
public class ReviewController {
    @Autowired
    ReviewRepository repo;
    @Autowired
    ReviewConverter conv;

    @GetMapping("/reviews")
    public List<ReviewWNoItem> getAll() 
    {
        return repo.findAll().stream().map(d -> conv.reviewToWNoItem(d)).toList();
    }
    
    @PostMapping("/reviews")
    public ReviewWItem insert(@RequestBody ReviewDtoRpost dto) 
    {
        if(dto.getScore()<=0||dto.getScore()>=11)
        {
            throw new IllegalArgumentException("Il valore della recensione deve essere compreso tra 1 e 10.");
        }
        else
        {
            Review d = conv.dtoRpostToReview(dto);
            return conv.reviewToWItem(repo.save(d));
        }
    }
    
    @GetMapping("/reviews/{id}")
    public ReviewWNoItem getOne(@PathVariable Integer id) 
    {
       Optional<Review> op = repo.findById(id);

       if(op.isEmpty())
        return null;

        return conv.reviewToWNoItem(op.get());
    }

    @GetMapping("/reviews/{id}/per")
    public ReviewWItem getOneWithPers(@PathVariable Integer id) 
    {
       Optional<Review> op = repo.findById(id);

       if(op.isEmpty())
        return null;

        return conv.reviewToWItem(op.get());
    }

    @PutMapping("/reviews")
    public ReviewWItem update(@RequestBody ReviewDtoRput dto) 
    {
        if(dto.getScore()<=0||dto.getScore()>=11)
        {
            throw new IllegalArgumentException("Il valore della recensione deve essere compreso tra 1 e 10.");
        }
        else
        {
            Review d = conv.dtoRputToReview(dto);
            return conv.reviewToWItem(repo.save(d));

        }
    }

    @PutMapping("/reviews/{id}")
    public ReviewWItem updateWithId(@RequestBody ReviewDtoRput dto,@PathVariable Integer id) 
    {
        if(dto.getScore()<=0||dto.getScore()>=11)
        {
            throw new IllegalArgumentException("Il valore della recensione deve essere compreso tra 1 e 10.");
        }
        else
        {
            dto.setId(id);
            Review d = conv.dtoRputToReview(dto);
            return conv.reviewToWItem(repo.save(d));
        }
    }

    @DeleteMapping("/reviews/{id}")
    public void  deleteReview(@PathVariable Integer id) 
    {
        repo.deleteById(id);
    }
}

