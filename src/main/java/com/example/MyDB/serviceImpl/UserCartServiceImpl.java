package com.example.MyDB.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.MyDB.exception.InternalServerErrorException;
import com.example.MyDB.exception.ResourceNotFoundException;
import com.example.MyDB.models.Product;
import com.example.MyDB.models.User;
import com.example.MyDB.models.UserCart;
import com.example.MyDB.repository.ProductRepository;
import com.example.MyDB.repository.UserCartRepository;
import com.example.MyDB.repository.UserRepository;
import com.example.MyDB.services.UserCartService;
import com.example.MyDB.utility.IConstant;
@Service
public class UserCartServiceImpl implements UserCartService{
	private static final Logger logger = LoggerFactory.getLogger(UserCartServiceImpl.class);
	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final UserCartRepository userCartRepository;
	public UserCartServiceImpl(UserRepository newUserRepository,ProductRepository newProductRepository, UserCartRepository userCartRepository) {
		this.userRepository = newUserRepository;
		this.productRepository = newProductRepository;
		this.userCartRepository = userCartRepository; 
	}
	@Override
	public ResponseEntity<?> getUserCartProduct(Long productId, Long userId){
		logger.info("Initiated Fetching User {} Cart Product:{}",userId,productId);
		try {
			Optional<User> usrObj = userRepository.findById(productId);
			if(!usrObj.isPresent()) {
				throw new ResourceNotFoundException(IConstant.USER_NOT_FOUND);
			}
			User usr = usrObj.get();
			UserCart cart = usrObj.get().getCart();
			Optional<UserCart> cartObj = userCartRepository.findById(cart.getId());
			if(! cartObj.isPresent()){
				throw new ResourceNotFoundException(IConstant.USER_CART_NOT_FOUND);
			}
			UserCart userCart = cartObj.get();
			List<Product> userCartProducts = userCart.getProducts();
			Optional<Product> product = productRepository.findById(productId);
			if(!product.isPresent()) throw new ResourceNotFoundException(IConstant.PRODUCT_NOT_FOUND);
			if(! userCartProducts.contains(product.get())) throw new ResourceNotFoundException(IConstant.USER_CART_PRODUCT_NOT_FOUND);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(product.get());
		}catch(ResourceNotFoundException e) {
			logger.warn("So didn't find something : {}",e.getMessage());
			throw e;
		}catch(Exception e) {
				throw new InternalServerErrorException(IConstant.PRODUCT_NOT_FOUND);
			}
	}
	@Override
	 public ResponseEntity<?> addProductToCart(Long product,Long userId) {
		try{
			Optional<User> usr = userRepository.findById(userId);
			if(! usr.isPresent()) {
				throw new ResourceNotFoundException(IConstant.USER_NOT_FOUND);
			}
			logger.info("User is present !");
			UserCart cart = usr.get().getCart();
			Optional<UserCart> userCartobj= userCartRepository.findById(cart.getId());
			if(!userCartobj.isPresent()) {
				throw new ResourceNotFoundException(IConstant.USER_CART_NOT_FOUND);
			}
			UserCart userCart = userCartobj.get();
			List<Product> cartProducts = userCart.getProducts();
			logger.info("Existing user cart: {}",cartProducts);
			Optional<Product> currProduct=productRepository.findById(product);
			if(! currProduct.isPresent()) throw new ResourceNotFoundException(IConstant.PRODUCT_NOT_FOUND);
			cartProducts.add(currProduct.get());
			userCartRepository.save(userCart);
			logger.info("Product added");
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(ResourceNotFoundException e) {
			logger.warn("So didn't find something : {}",e.getMessage());
			throw e;
		}catch(Exception e) {
			throw new InternalServerErrorException(IConstant.INTERNAL_SERVER_ERROR);
		
		}
	}
	
	@Override
	public ResponseEntity<?> deleteProductFromCart(Long productId, Long userId) {
		try{
			Optional<User> usr = userRepository.findById(userId);
			if(! usr.isPresent()) {
				throw new ResourceNotFoundException(IConstant.USER_NOT_FOUND);
			}
			logger.info("user is present !");
			UserCart cart = usr.get().getCart();
			Optional<UserCart> userCartobj= userCartRepository.findById(cart.getId());
			if(! userCartobj.isPresent()) {
				logger.warn("We don't have the cart for the user {}",usr.get().getName());
				throw new ResourceNotFoundException(IConstant.USER_CART_NOT_FOUND);
			}
			UserCart userCart = userCartobj.get();
			logger.info("User cart is also present here it is :{}",userCart);
			List<Product> cartProducts = userCart.getProducts();
			Optional<Product> product = productRepository.findById(productId);
			if(!product.isPresent()) throw new ResourceNotFoundException(IConstant.PRODUCT_NOT_FOUND);
			cartProducts.remove(product.get());
			userCartRepository.save(userCart);
			logger.info("Product Got removed from user cart, new one is {}");
			return ResponseEntity.status(HttpStatus.CREATED).build();			
		}catch(ResourceNotFoundException e) {
			logger.warn("So didn't find something : {}",e.getMessage());
			throw e;
		}catch(Exception e) {
			throw new InternalServerErrorException(IConstant.INTERNAL_SERVER_ERROR);
		}
	 }

}
