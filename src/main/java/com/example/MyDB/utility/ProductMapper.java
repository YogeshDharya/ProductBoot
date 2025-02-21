package com.example.MyDB.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.example.MyDB.dto.ProductRequest;
import com.example.MyDB.dto.ProductResponse;
import com.example.MyDB.models.Product;

public class ProductMapper {

	public static ProductResponse mapEntityToProductResponse(Product product) {
		Long Id = product.getId();
		String name = product.getName();
		String description = product.getDescription();
		Double price = product.getPrice();
		ProductResponse response = new ProductResponse(Id,name,description,price);
		return response;
	}
	public static Product mapProductRequestToEntity(ProductRequest request) {
		Product product= new Product(
				request.getName(),
				request.getDescription(),
				request.getPrice()
				);
		return product;
	}
	
	public static ProductRequest mapProductToProductRequest(Product product) {
		List<Long> userCartIds = product.getUserCarts().
					stream().
					map(userCart -> userCart.getId())
					.collect(Collectors.toList());
		ProductRequest request = new ProductRequest(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				userCartIds
				) ;
		return request;
	}
	
}
