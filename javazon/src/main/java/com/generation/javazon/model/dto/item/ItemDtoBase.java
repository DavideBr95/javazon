package com.generation.javazon.model.dto.item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ItemDtoBase {
    private String name, description, producedBy, madeIn, imgUrl;
    private double price;
    private boolean available;  
}
