package com.generation.javazon.model.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name, description, producedBy, madeIn, imgUrl;
    private double price;
    private boolean available;    
    
    @JsonIgnore
    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private List<Review> reviews;

    @JsonIgnore
    @OneToMany(mappedBy = "bought",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<DeliveryItem> deliveryItems;
}
