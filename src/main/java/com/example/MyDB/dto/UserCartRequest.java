package com.example.MyDB.dto;

import java.util.List;

public class UserCartRequest {
	private Long userId;

	List<Long> cartProductIds;
	
	public UserCartRequest(Long usrId,List<Long> productIds) {
		this.userId = usrId;
		this.cartProductIds= productIds;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	
	public List<Long> getCartProductIds(){
		return this.cartProductIds;
	}

	public void setCartProductIds(List<Long> newProductIds) {
		this.cartProductIds = newProductIds;
	}
}
