package com.generation.javazon.model.dto.delivery;

import java.util.List;

import com.generation.javazon.model.entities.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DeliveryDtoWWithItemsAug extends DeliveryDtoBase{

    private Integer id;

    private List<Item> items;

    private double totRevenue;
    private int quantity;
}
