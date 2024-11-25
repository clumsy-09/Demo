package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Method to get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to get a product by SKU
    public Optional<Product> getProductBySku(String sku) {
        return productRepository.findById(sku);
    }

    // Method to find products by name (optional)
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }
}
