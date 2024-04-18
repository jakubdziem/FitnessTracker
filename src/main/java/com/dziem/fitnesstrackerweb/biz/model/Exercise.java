package com.dziem.fitnesstrackerweb.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exercise {
    @Id
    @GeneratedValue
    Long id;
    @NotEmpty(message = "Name of the exercise must be defined.")
    String name;
    @NotNull(message = "Number of sets must be defined.")
    @Min(value = 1, message = "Number of sets must be greater than 0.")
    Integer sets;
    @NotNull(message = "Number of repetitions must be defined.")
    @Min(value = 1, message = "Number of repetitions must be greater than 0.")
    Integer repetitions;
    Time duration;
    @DecimalMin(value="0.25", message = "Weight must be at least 0.25")
    BigDecimal weight;
    //tutaj trzeba jakas walidacje zeby sie dalo albo to albo to albo oba xD
}
