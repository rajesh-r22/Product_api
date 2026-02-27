package com.example.project_assignment.service;

import com.example.project_assignment.entity.Product;
import com.example.project_assignment.exceptions.BadRequestException;
import com.example.project_assignment.exceptions.ResourceNotFoundException;
import com.example.project_assignment.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
         return productRepository.findAll();
    }

    public List<Product> findByName(String name) {
        if (name == null || name.isBlank()) {
            throw new ResourceNotFoundException("Product name cannot be empty");
        }
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public Product addProduct(Product product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new BadRequestException("Product name cannot be empty");
        }
        return productRepository.save(product);
    }


    public Product updateProduct(UUID id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " does not exist"));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrand(product.getBrand());

        return productRepository.save(existingProduct);
    }
    public void  deleteProduct(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product with id: " + id + " does not exist");
        }
        productRepository.deleteById(id);

    }

}
