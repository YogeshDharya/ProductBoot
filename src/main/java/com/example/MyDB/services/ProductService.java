package com.example.MyDB.services;

import org.springframework.http.ResponseEntity;

import com.example.MyDB.utility.CustomRequest;

import jakarta.validation.Valid;

public interface ProductService {

	ResponseEntity<?> getAllProducts();

	ResponseEntity<?> getProductById(Long productId);

	ResponseEntity<?> saveProduct(@Valid CustomRequest request);

	ResponseEntity<?> deleteProduct(Long productId);
	
	ResponseEntity<?> changeProductName(CustomRequest request);
}
