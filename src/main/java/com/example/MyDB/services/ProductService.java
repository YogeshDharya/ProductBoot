package com.example.MyDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.MyDB.dto.ProductDto;
import com.example.MyDB.models.Product;

import jakarta.validation.Valid;

public interface ProductService {

	ResponseEntity<?> getAllProducts();

	ResponseEntity<?> getProductById(Long productId);

	ResponseEntity<?> saveProduct(@Valid Product product);

	ResponseEntity<?> deleteProduct(Long productId);
}
