package com.example.MyDB.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.MyDB.dto.ProductMapper;
import com.example.MyDB.exception.InternalServerErrorException;
import com.example.MyDB.exception.ResourceNotFoundException;
import com.example.MyDB.models.Product;
import com.example.MyDB.repository.ProductRepository;
import com.example.MyDB.services.ProductService;
import com.example.MyDB.utility.CustomRequest;
import com.example.MyDB.utility.IConstant;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	public ProductServiceImpl(ProductRepository repositoryImplObject) {
		this.repository = repositoryImplObject;
	}

	@Override
	public ResponseEntity<?> getAllProducts() {
		logger.info("Initiated Deleting product");
		try {
			List<Product> products = repository.findAll();
			logger.info("Successfully Fetched All Products!");
			return ResponseEntity.ok().body(products);
		} catch (Exception ex) {
			logger.error("No Products To Display ! Error:" + ex.getMessage());
			ResponseEntity.status(HttpStatus.NO_CONTENT).body(IConstant.PRODUCT_NOT_FOUND);
			throw new ResourceNotFoundException(ex.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> getProductById(Long productId) {
		logger.info("Fetching the product : %s", productId);
		try {
			Optional<Product> product = repository.findById(productId);
			logger.info("Sucessfully fetched Product !:");
			return ResponseEntity.ok().body(product);
		} catch (Exception ex) {
			logger.error("Error Encountered while fetching object: {}, error: {}", ex.getMessage());
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(IConstant.PRODUCT_NOT_FOUND);
			throw new ResourceNotFoundException(ex.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> saveProduct(CustomRequest request) {
		Product product = ProductMapper.mapCustomRequestToEntity(request);
		logger.info("Initiated saving product: {}", product.getName());
		try {
			repository.save(product);
			logger.info("Sucessfully Created Product {}!", product.getId());
			return ResponseEntity.ok("Sucessfully Created Product for id :"+product.getId());
		} catch (Exception e) {
			logger.error("Couldn't save product : %s, error: %s", product.getName(), e.getMessage());
			ResponseEntity.status(HttpStatus.BAD_REQUEST);
			throw new InternalServerErrorException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> changeProductName(CustomRequest request){
			Long id = request.getId();
			String name = request.getName();
			Optional<Product> product = repository.findById(id);
			if(product.isPresent()) {
				product.get().setName(name);
				ResponseEntity.status(HttpStatus.OK).body(product.get());
			}else {
				ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				throw new ResourceNotFoundException(IConstant.PRODUCT_NOT_FOUND);
			}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(product.get());
	}
	
	@Override
	public ResponseEntity<?> deleteProduct(Long productId) {
		logger.info("Initiated Deleting product: {}", productId);
		if (repository.findById(productId).isPresent()) {
			repository.deleteById(productId);
			logger.info("Product Sucessfully Deleted !");
			return ResponseEntity.noContent().build();
		} else {
			logger.warn("Attempted To Delete a Non-Existent product:{}", productId);
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(IConstant.PRODUCT_NOT_FOUND);
			throw new ResourceNotFoundException("Product Not Found");
		}
	}

}