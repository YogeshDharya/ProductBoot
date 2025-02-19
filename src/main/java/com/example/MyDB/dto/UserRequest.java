package com.example.MyDB.dto;

import com.example.MyDB.models.UserCart;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public class UserRequest {
//	@Schema(description="Unique Identifier for the user request")
	private Long id;
	
	@NotEmpty
//	@Schema(description="Name of the customer")
	private String name;
	
//	@Schema(description="Cart, the customer has")
	private UserCart userCart;
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long newId) {
		this.id = newId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public UserCart getCart() {
		return this.userCart;
	}
	public void setCart(UserCart newCart) {
		this.userCart = newCart;
	}
}
