package com.example.MyDB.utility;

import com.example.MyDB.models.Product;
import com.example.MyDB.dto.*;

public class ProductMapper {

	public static ProductResponse mapEntityToCustomResponse(Product product) {
		ProductResponse response = new ProductResponse(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getPrice()
				);
		return response;
	}
	public static Product mapCustomRequestToEntity(ProductRequest request) {
		Product product= new Product(
				request.getName(),
				request.getDescription(),
				request.getPrice()
				);
		return product;
	}
//		Product product = new Product(
//				productdto.getName(),
//				productdto.getDescription(),
//				productdto.getPrice());
	
}
