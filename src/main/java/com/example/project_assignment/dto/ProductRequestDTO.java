package com.example.project_assignment.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Valid
public class ProductRequestDTO {
    @NotBlank
    private String name;

    @Size(max = 1000)
    private String description;

    @NotBlank
    private String brand;

    private String category;

    @Positive
    @DecimalMin(value = "0.0", inclusive = false)
    private double price;
}