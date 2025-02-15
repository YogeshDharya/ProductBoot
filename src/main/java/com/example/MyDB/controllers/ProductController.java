package com.example.MyDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyDB.services.ProductService;
import com.example.MyDB.utility.CustomRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Validated
@Tag(name = "Product Controller", description = "APIs for managing products")
public class ProductController {

	private final ProductService serviceInterface;

	@Autowired
	public ProductController(ProductService serviceImplObject) {
		this.serviceInterface = serviceImplObject;
	}

	@Operation(summary = "Get all products", description = "Retrieve a list of all products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved list of products", content = @Content(schema = @Schema(implementation = CustomRequest.class))),
			@ApiResponse(responseCode = "404", description = "No products found",content= @Content )})
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts() {
		return serviceInterface.getAllProducts();
	}
	@Operation(summary="Changes the name of an existing product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully Changed Product Name", content= @Content(schema= @Schema(implementation = CustomRequest.class))),
			@ApiResponse(responseCode = "404", description= "Product Not Found", content = @Content)})
	public ResponseEntity<?> changeProductName(CustomRequest request){
		return serviceInterface.changeProductName(request);
	}
	@Operation(summary = "Get a product by ID", description = "Retrieve a product by its ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved product", content = @Content(schema = @Schema(implementation = CustomRequest.class))),
			@ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProduct(@Valid @RequestParam Long productId) {
		return serviceInterface.getProductById(productId);
	}
	
	
	
	@Operation(summary = "Save a product", description = "Save a new product to the database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Product successfully saved", content = @Content(schema = @Schema(implementation = CustomRequest.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
	@PostMapping("/products")
	public ResponseEntity<?> saveProduct(@Valid @RequestBody CustomRequest requestEntity) {
		return serviceInterface.saveProduct(requestEntity);
	}

	@Operation(summary = "Delete a product by ID", description = "Delete a product from the database by its ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Product successfully deleted", content = @Content),
			@ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@RequestParam Long productId) {
		return serviceInterface.deleteProduct(productId);
	}
}