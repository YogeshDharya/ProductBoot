package com.example.MyDB.dto;

//import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public class UserRequest {
//	@Schema(description="Unique Identifier for the user request")
	private Long id;
	
	@NotEmpty
//	@Schema(description="Name of the customer is a required field")
	private String name;
	
//	@Schema(description="Cart, the customer has; its Id is a required field")
	private Long userCartId;
	
	public UserRequest(Long id,String name,Long userCartId) {
		this.id= id;
		this.name = name;
		this.userCartId = userCartId;
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
	public void setCartId(Long newCart) {
		this.userCartId = newCart;
	}
}
