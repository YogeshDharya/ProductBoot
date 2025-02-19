package com.example.MyDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyDB.models.Product;
import com.example.MyDB.models.UserCart;
import com.example.MyDB.services.UserCartService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "User Cart Controller", description = "Controller for managing uset cart products")
public class UserCartController {

	private final UserCartService serviceInterface;

	@Autowired
	public UserCartController(UserCartService serviceImplObject) {
		this.serviceInterface = serviceImplObject;
	}

	@Operation(summary = "Add Product to User Cart ", description = "Saves a new product into the Specified User's Cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Product successfully addedd to User Cart", content = @Content(schema = @Schema(implementation = UserCart.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
	@PostMapping("/user-cart/{userId}/product/{productId}")
	public ResponseEntity<?> saveProduct(@RequestParam Long userId, Long productId) {
		return serviceInterface.addProductToCart(productId, userId);
	}

	@Operation(summary = "Delete Product from User Cart ", description = "Deletes a product from the Specified User's Cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product successfully deleted from User Cart", content = @Content(schema = @Schema(implementation = UserCart.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
	@DeleteMapping("/user-cart/{userId}/product/{productId}")
	public ResponseEntity<?> deleteCartProduct(@RequestParam Long productId, Long userId) {
		return serviceInterface.deleteProductFromCart(productId, userId);
	}

	@Operation(summary = "Fetch Product from User Cart ", description = "Fetches a desired product from the Specified User's Cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product successfully fetched from User Cart", content = @Content(schema = @Schema(implementation = UserCart.class))),
			@ApiResponse(responseCode = "500", description = "Backend Misbehaving ", content = @Content) })
	@GetMapping("/user-cart/{id}/product/{productId}")
	public ResponseEntity<?> getUserCartProduct(@RequestParam Long productId, Long userId) {
		return serviceInterface.deleteProductFromCart(productId, userId);
	}
}