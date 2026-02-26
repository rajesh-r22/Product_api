package com.example.project_assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String name;

    @Size(max=1000)
    private String description;

    @NotBlank
    private String brand;

    @NotEmpty
    private String category;

    @Positive
    @DecimalMin(value = "0.0", inclusive = false)
    private double price;

    @CreationTimestamp
    private LocalDateTime created_at;
}
