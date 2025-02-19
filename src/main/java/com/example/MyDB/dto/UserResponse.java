package com.example.MyDB.dto;

import com.example.MyDB.models.UserCart;

public class UserResponse {
	private Long id;
	private String name;
	private UserCart userCart;

	public UserResponse(Long id, String name, UserCart cart) {
		this.id = id;
		this.name = name;
		this.userCart = cart;
	}

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
