package com.example.MyDB.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.MyDB.dto.UserRequest;
import com.example.MyDB.exception.InternalServerErrorException;
import com.example.MyDB.exception.ResourceNotFoundException;
import com.example.MyDB.models.Product;
import com.example.MyDB.models.User;
import com.example.MyDB.models.UserCart;
import com.example.MyDB.repository.ProductRepository;
import com.example.MyDB.repository.UserCartRepository;
import com.example.MyDB.repository.UserRepository;
import com.example.MyDB.services.UserService;
import com.example.MyDB.utility.IConstant;
import com.example.MyDB.utility.UserMapper;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;
	private ProductRepository productRepository;
	private UserCartRepository userCartRepository;
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	public UserServiceImpl(UserRepository repo,ProductRepository productReppsitory,UserCartRepository userCartRepository) {
		this.repository = repo;
		this.userCartRepository = userCartRepository;
		this.productRepository = productReppsitory;
	}
	
	@Override
	public ResponseEntity<?> getAllUsers(){
		logger.info("Initiated Fetching Users");
		try {			
			List<User> users= repository.findAll();
			logger.info("Successfully Fetched All Users");
			return ResponseEntity.status(HttpStatus.OK).body(users);
		}catch(Exception e) {
			logger.warn("Server is malfunctioning");
			throw new InternalServerErrorException(e.getMessage());
		}
	}
	
	@Override 
	public ResponseEntity<User> getUserById(Long userId){
		logger.info("Initiated fetching user ");
		try {
			Optional<User> usr = repository.findById(userId);
			logger.info("Sucessfully Fetched the desired user id:{}",userId);
			return ResponseEntity.status(HttpStatus.OK).body(usr.get());
		}catch(Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
	
	
	
	@Override
	public ResponseEntity<?> saveUser(@Valid UserRequest request){
		User usr = UserMapper.mapRequestToUser(request);
		
		UserCart currCart = usr.getCart();
		List<Product> productList = currCart.getProducts();
		
		productList.forEach((product) -> {
			productRepository.save(product);
		});
		userCartRepository.save(currCart);
		logger.info("Initiated saving user: {}",usr.getName());
		try {
			repository.save(usr);
			logger.info("Successfully Saved the User");
			return ResponseEntity.status(HttpStatus.OK).body(usr.getId());
		}catch(Exception e) {
			logger.error("Error Saving User !: "+e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
		}
	}
	
	@Override 
	public ResponseEntity<?> getUserCart(Long userId){
		logger.info("Initiated fetching User Cart");
		try {
			Optional<User> usr = repository.findById(userId);
			logger.info("User Cart fetched !");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usr.get().getCart());
		}catch(Exception e) {
			logger.info("Failed fetching user cart. Error: {}",e.getMessage());
			throw new ResourceNotFoundException(IConstant.USER_NOT_FOUND);
		}
		}
		
	
}
