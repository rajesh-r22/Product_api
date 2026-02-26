package com.example.project_assignment.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private String brand;
    private String category;
    private double price;
    private LocalDateTime createdAt;

}
