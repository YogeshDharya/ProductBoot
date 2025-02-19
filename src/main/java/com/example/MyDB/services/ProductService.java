package com.example.MyDB.services;

import org.springframework.http.ResponseEntity;


import com.example.MyDB.dto.ProductRequest;

import jakarta.validation.Valid;

public interface ProductService {

	ResponseEntity<?> getAllProducts();

	ResponseEntity<?> getProductById(Long productId);

	ResponseEntity<?> saveProduct(@Valid ProductRequest request);

	ResponseEntity<?> deleteProduct(Long productId);
	
	ResponseEntity<?> changeProduct(@Valid ProductRequest request);
}
