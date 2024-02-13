package com.generation.javazon.model.dto.item;
import java.util.List;

import com.generation.javazon.model.entities.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ItemDtoWFull extends ItemDtoBase {
    private Integer id;
    private List<Review> reviews;
}
