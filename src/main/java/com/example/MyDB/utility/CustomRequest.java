package com.example.MyDB.utility;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CustomRequest {//Diff for each Entity
	
	@NotEmpty(message="Product name cannot be empty")
	@Size(min=5, max=30, message="Product name should be at least 5 characters long")
	private String name;
	
	@NotEmpty(message="Product Description cannot be Empty")
	private String description;

	@NotEmpty(message="Not For Free !")
	@Size(min=99, message="Product should be costlier than Rs 99")
	private Double price;
	
	public CustomRequest() {}
	public CustomRequest(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
	}
	public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
