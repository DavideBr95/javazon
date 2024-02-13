package com.generation.javazon.model.dto.employee;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EmployeeDtoBase {

    private String name,surname,address,role,imgUrl;
    private LocalDate dob, hiredOn;
    private int securityLevel, salary;

}
