package com.generation.javazon.model.dtoservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.generation.javazon.model.dto.item.ItemDtoR;
import com.generation.javazon.model.dto.item.ItemDtoWFull;
import com.generation.javazon.model.dto.item.ItemDtoWNoReview;
import com.generation.javazon.model.entities.Item;
import com.generation.javazon.model.entities.Review;
@Service 
public class ItemConverter {
    public Item dtoRToItem(ItemDtoR dto)
    {
        return  Item
                .builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .producedBy(dto.getProducedBy())
                .madeIn(dto.getMadeIn())
                .imgUrl(dto.getImgUrl())
                .price(dto.getPrice())
                .available(dto.isAvailable())
                .build();
    }

    public ItemDtoWFull ItemToDtoWFull(Item e)
    {
        return  ItemDtoWFull
                .builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .producedBy(e.getProducedBy())
                .madeIn(e.getMadeIn())
                .imgUrl(e.getImgUrl())
                .price(e.getPrice())
                .available(e.isAvailable())
                .reviews(e.getReviews())
                .build();
    }

    public ItemDtoWNoReview ItemToDtoWNoDocuments (Item e)
    {
        return  ItemDtoWNoReview
                .builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .producedBy(e.getProducedBy())
                .madeIn(e.getMadeIn())
                .imgUrl(e.getImgUrl())
                .price(e.getPrice())
                .available(e.isAvailable())
                .build();
    }

    public Double getAverage(Item it)
    {
        List<Review> reviews = it.getReviews();
        double sum = 0;

        for(Review r : reviews)
        {
            sum += r.getScore();
        }

        return sum/reviews.size();
    }
}

