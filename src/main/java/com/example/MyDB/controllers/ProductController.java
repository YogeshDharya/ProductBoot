package com.example.MyDB.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyDB.dto.ProductMapper;
import com.example.MyDB.models.Product;
import com.example.MyDB.serviceImpl.ProductServiceImpl;
import com.example.MyDB.services.ProductService;
import com.example.MyDB.utility.CustomRequest;
import com.example.MyDB.utility.CustomResponse;
import com.example.MyDB.utility.IConstant;

import jakarta.validation.Valid;

@RestController
@Validated
public class ProductController {
	private final ProductService serviceInterface;
	private  ProductMapper mapper;
	private  IConstant iConstant;
	private CustomRequest productRequest;
	private CustomResponse productResponse;
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	public ProductController(ProductService serviceImplObject) {
		this.serviceInterface = serviceImplObject;
	}

	@GetMapping("/products")
		public ResponseEntity<?> getAllProducts() {
		return  serviceInterface.getAllProducts();
	}

	@PostMapping("/products")
	public ResponseEntity<?> saveProduct(@Valid @RequestBody CustomRequest requestEntity) {
		  Product product = mapper.mapDtoToEntity(requestEntity);
		  return serviceInterface.saveProduct(product);
		 }


	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProduct(@Valid  @PathVariable Long productId) {
			return serviceInterface.getProductById(productId);
	}
	

	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
		return serviceInterface.deleteProduct(productId);
	}
}
