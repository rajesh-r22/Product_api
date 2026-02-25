package com.example.project_assignment.repository;

import com.example.project_assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    //  for exact match with product name
    List<Product> findByName(String name);
//     partial match with product name
    List<Product> findByNameContainingIgnoreCase(String name);
}
