package com.example.MyDB.dto;

import com.example.MyDB.models.Product;
import com.example.MyDB.utility.*;

public class ProductMapper {
	public Product mapDtoToEntity(CustomRequest requestEntity) {
		//Empty entity constructor for proxy instantiation 
		Product product = new Product();
		product.setName(requestEntity.getName()) ;
		product.setDescription(requestEntity.getDescription());
		product.setPrice(requestEntity.getPrice());
		return product;
	}
	public CustomResponse mapEntityToCustomResponse(Product product) {
		CustomResponse response = new CustomResponse(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getPrice()
				);
		return response;
	}
//		Product product = new Product(
//				productdto.getName(),
//				productdto.getDescription(),
//				productdto.getPrice());
	
}
