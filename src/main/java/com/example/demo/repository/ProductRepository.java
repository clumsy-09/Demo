package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    // You can add custom query methods here if needed
    // For example, find by name
    List<Product> findByName(String name);
}
