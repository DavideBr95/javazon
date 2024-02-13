package com.generation.javazon.model.dtoservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javazon.model.dto.review.ReviewDtoRpost;
import com.generation.javazon.model.dto.review.ReviewDtoRput;
import com.generation.javazon.model.dto.review.ReviewWItem;
import com.generation.javazon.model.dto.review.ReviewWNoItem;
import com.generation.javazon.model.entities.Item;
import com.generation.javazon.model.entities.Review;
import com.generation.javazon.model.repositories.ItemRepository;


@Service

public class ReviewConverter {
    @Autowired
    ItemRepository iRepo;

    public ReviewWNoItem reviewToWNoItem(Review r) {
        return ReviewWNoItem
                .builder()
                .id(r.getId())
                .sender(r.getSender())
                .score(r.getScore())
                .date(r.getDate())
                .build();
    }

    public ReviewWItem reviewToWItem(Review r) {
        return ReviewWItem
                .builder()
                .id(r.getId())
                .sender(r.getSender())
                .score(r.getScore())
                .date(r.getDate())
                .build();
    }

    public Review dtoRpostToReview(ReviewDtoRpost dto) {
        Item padre = iRepo.findById(dto.getItem_id()).get();
        return Review
                .builder()
                .sender(dto.getSender())
                .score(dto.getScore())
                .date(dto.getDate())
                .item(padre)

                .build();
    }

    public Review dtoRputToReview(ReviewDtoRput dto) {
        Item padre = null;

        Integer item_id = dto.getItem_id();

        if (item_id != null) {
            Optional<Item> op = iRepo.findById(item_id);

            if (op.isPresent())
                padre = op.get();
        }
        return Review
                .builder()
                .id(dto.getId())
                .sender(dto.getSender())
                .score(dto.getScore())
                .date(dto.getDate())
                .item(padre)
                .build();
    }

}
