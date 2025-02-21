package com.example.MyDB.dto;

import java.util.List;

import com.example.MyDB.utility.IConstant;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

public class ProductRequest {

	@Id
//	@Schema(description="Unique Identifier of the request product object")
	private Long id;

	@NotEmpty(message = IConstant.PROUCT_NAME_VACANT)
//	@Size(min=5, max=30, message=IConstant.PROUCT_NAME_SIZE)
//	@Schema(description="Name of the Product entity ")
	private String name;

	@NotEmpty(message = IConstant.PRODUCT_DECRIPTION_MESSAGE)
//	@Schema(description="Description of the product entity")
	private String description;

//	@NotEmpty(message=IConstant.PRODUCT_PRICE_VACANT)
//	@Size(min=99, message=IConstant.PRODUCT_PRICE_MESSAGE)
//	@Schema(description="Price of the Product entity")
	private Double price;

	public ProductRequest() {
	}

	public ProductRequest(Long id,String name, String description, Double price,List<Long> newCartIds) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
