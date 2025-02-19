package com.example.MyDB.dto;

import java.util.List;

public class UserCartRequest {
	private Long userId;
	List<Long> cartProducts;
	
	public UserCartRequest(Long usrId,List<Long> products) {
		this.userId = usrId;
		this.cartProducts = products;
	}
}
