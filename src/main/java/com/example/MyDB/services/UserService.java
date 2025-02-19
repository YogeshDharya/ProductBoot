package com.example.MyDB.services;

import org.springframework.http.ResponseEntity;

import com.example.MyDB.dto.UserRequest;
import com.example.MyDB.models.Product;

import jakarta.validation.Valid;

public interface UserService {
	ResponseEntity<?> getAllUsers();

	ResponseEntity<?> getUserById(Long userId);

	ResponseEntity<?> saveUser(@Valid UserRequest request);

	ResponseEntity<?> getUserCart(Long userId);
}
