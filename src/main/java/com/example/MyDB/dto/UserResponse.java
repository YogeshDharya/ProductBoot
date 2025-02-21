package com.example.MyDB.dto;

import com.example.MyDB.models.UserCart;

public class UserResponse {
	private Long id;
	private String name;
	private Long userCartId;

	public UserResponse(Long id, String name, Long cartId) {
		this.id = id;
		this.name = name;
		this.userCartId = cartId;
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

	public Long getCartId() {
		return this.userCartId;
	}

	public void setCart(Long newCartId) {
		this.userCartId= newCartId;
	}
}
