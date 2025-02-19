package com.example.MyDB.utility;

import com.example.MyDB.dto.UserRequest;
import com.example.MyDB.dto.UserResponse;
import com.example.MyDB.models.User;

public class UserMapper {
	public static UserResponse mapUserToReponse(User usr) {
		UserResponse response = new UserResponse(
				usr.getId(),
				usr.getName(),
				usr.getCart());
				return response;
	}
	public static User mapRequestToUser(UserRequest request) {
		User usr = new User();
				usr.setId(request.getId());
				usr.setName(request.getName());
				usr.setCart(request.getCart());				
		return usr;
				
	}
}
