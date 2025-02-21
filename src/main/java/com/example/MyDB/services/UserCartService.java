package com.example.MyDB.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.MyDB.dto.UserCartRequest;
import com.example.MyDB.models.User;
import com.example.MyDB.models.UserCart;


@Service
public interface UserCartService {
	ResponseEntity<?> addProductToCart(UserCartRequest request);

	ResponseEntity<?> deleteProductFromCart(Long userId, Long productId);

	ResponseEntity<?> getUserCartProduct(Long productId, Long userId);

	UserCart getUserCart(Long userId);

	UserCart addUserCart(UserCartRequest request);
}
