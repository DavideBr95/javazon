package com.generation.javazon.model.dto.review;


import com.generation.javazon.model.entities.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class ReviewWItem extends ReviewDtoBase {

    private Integer id;
    private Item item;
}
