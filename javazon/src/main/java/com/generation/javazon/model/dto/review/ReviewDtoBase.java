package com.generation.javazon.model.dto.review;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ReviewDtoBase {

    private String sender;
    private LocalDate date;
    private int score;
   
}
