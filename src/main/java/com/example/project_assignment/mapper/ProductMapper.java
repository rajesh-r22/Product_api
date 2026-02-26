package com.example.project_assignment.mapper;

import com.example.project_assignment.dto.ProductRequestDTO;
import com.example.project_assignment.dto.ProductResponseDTO;
import com.example.project_assignment.entity.Product;

public class ProductMapper {
//    DTO conversion to entity
    public static Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setBrand(dto.getBrand());
        product.setDescription(dto.getDescription());
        return product;
    }
//
//  entity conversion to DtO for response
    public static ProductResponseDTO toResponseDTO(Product entity) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreated_at());
        dto.setName(entity.getName());
        dto.setCategory(entity.getCategory());
        dto.setPrice(entity.getPrice());
        dto.setBrand(entity.getBrand());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
