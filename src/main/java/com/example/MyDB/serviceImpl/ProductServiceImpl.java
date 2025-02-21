package com.example.MyDB.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.MyDB.utility.ProductMapper;
import com.example.MyDB.exception.InternalServerErrorException;
import com.example.MyDB.exception.ResourceNotFoundException;
import com.example.MyDB.models.Product;
import com.example.MyDB.repository.ProductRepository;
import com.example.MyDB.services.ProductService;
import com.example.MyDB.dto.ProductRequest;
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
			logger.error("Error Encountered while fetching object: {}, error: {}",productId, ex.getMessage());
			throw new ResourceNotFoundException(ex.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> saveProduct(ProductRequest request) {
		Product product = ProductMapper.mapProductRequestToEntity(request);
		logger.info("Initiated saving product: {}", product.getName());
		try {
			repository.save(product);
			logger.info("Sucessfully Created Product {}!", product.getId());
			return ResponseEntity.ok("Sucessfully Created Product for id :"+product.getId());
		} catch (Exception e) {
			logger.warn("Couldn't save product : %s, error: %s", product.getName(), e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> changeProduct(ProductRequest request){
			Long id = request.getId();
			logger.info("Initiated Renaming the product");
			try {
				Optional<Product> product = repository.findById(id);
				if(!product.isPresent()) {
					logger.error("Product {} was not even present !",request.getName());
					ResponseEntity.status(HttpStatus.OK).body(product.get());
					throw new ResourceNotFoundException(IConstant.PRODUCT_NOT_FOUND);
				}
					Product currProduct = product.get();
					currProduct.setName(request.getName());
					currProduct.setPrice(request.getPrice());
					currProduct.setDescription(request.getDescription());
					repository.save(currProduct);
					logger.info("Successfully Renamed the product: {}",product.get().getName());
					return ResponseEntity.status(HttpStatus.OK).body(product.get());	
			}catch(ResourceNotFoundException e) {
				logger.error(e.getMessage());
				throw new ResourceNotFoundException(IConstant.PRODUCT_NOT_FOUND);
			}catch(Exception e) {
				logger.warn(e.getMessage());
				throw new InternalServerErrorException(IConstant.INTERNAL_SERVER_ERROR);
			}	
	}
	
	@Override
	public ResponseEntity<?> deleteProduct(Long productId) {
		logger.info("Initiated Deleting product: {}", productId);
		try {
			repository.deleteById(productId);
			logger.info("Product Sucessfully Deleted !");
			return ResponseEntity.noContent().build();
		} catch(Exception e) {
			logger.error("Attempted To Delete a Non-Existent product:{} Error :{}", productId,e.getMessage());
			throw new ResourceNotFoundException("Product Not Found");
		}
	}

}