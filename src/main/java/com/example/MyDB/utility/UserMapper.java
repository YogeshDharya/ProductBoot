package com.example.MyDB.utility;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.MyDB.dto.UserResponse;
import com.example.MyDB.exception.ResourceNotFoundException;
import com.example.MyDB.models.User;
import com.example.MyDB.models.UserCart;
import com.example.MyDB.repository.UserCartRepository;
import com.example.MyDB.repository.UserRepository;

@Component
public class UserMapper {
	@Autowired
	private UserRepository userRepository;
	public  UserResponse mapUserToResponse(User usr) {
				Optional<User> userObj=userRepository.findById(usr.getId());
				if(! userObj.isPresent()) throw new ResourceNotFoundException(IConstant.USER_NOT_FOUND);
				User user = userObj.get();
				UserCart userCart = user.getCart();
				UserResponse response = new UserResponse(
				user.getId(),
				user.getName(),
				userCart.getId()
				);
				return response;
	}
}
