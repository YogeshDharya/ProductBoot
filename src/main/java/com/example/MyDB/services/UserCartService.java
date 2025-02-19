package com.example.MyDB.services;

import org.springframework.http.ResponseEntity;

import com.example.MyDB.models.Product;


public interface UserCartService {
	ResponseEntity<?> addProductToCart(Long product,Long userId);
	 ResponseEntity<?> deleteProductFromCart(Long productId, Long userId);
	ResponseEntity<?> getUserCartProduct(Long productId, Long userId);
}
