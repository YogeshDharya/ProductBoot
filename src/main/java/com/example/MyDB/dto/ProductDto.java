package com.example.MyDB.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
public class ProductDto {
	
	@NotEmpty(message = "Product Name is Required")
	@Size(min=5, max=30, message="Product Name should be at least 5 characters long")
	private String name;
	
	@NotEmpty(message = "Product Description is Required")
	private String description;
	
	@NotEmpty(message = "Product Price is Required")
	@Size(min=99, max=10000, message="Product Price should be at least Rs 99 ")
	private Double price;
	
	private Long id;
	
	public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
	
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double newPrice) {
        this.price = newPrice;
    }
    
    public ProductDto(String name,String description,Double price,Long id) {
    	this.name = name;
    	this.description=description;
    	this.price=price;
    	this.id=id;
    }
}
