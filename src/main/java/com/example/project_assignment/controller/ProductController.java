package com.example.project_assignment.controller;

import com.example.project_assignment.dto.ProductRequestDTO;
import com.example.project_assignment.dto.ProductResponseDTO;
import com.example.project_assignment.entity.Product;
import com.example.project_assignment.mapper.ProductMapper;
import com.example.project_assignment.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getByName(@RequestParam String name) {
        List<Product> products = productService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        Product product= ProductMapper.toEntity(productRequestDTO);
        Product saved=productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductMapper.toResponseDTO(saved));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Product> updateProduct(@Valid @PathVariable UUID uuid, @RequestBody Product product) {
        Product update = productService.updateProduct(uuid, product);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/{uuid}")
    public  ResponseEntity<String> deleteProduct(@PathVariable UUID uuid) {
        productService.deleteProduct(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}



