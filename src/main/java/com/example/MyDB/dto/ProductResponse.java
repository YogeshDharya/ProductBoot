package com.example.MyDB.dto;

import java.util.List;

public class ProductResponse {
	private Long id;
	private String name;
	private String description;
	private Double price;
	public ProductResponse(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
	
    public Long getId() { 
    	return id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
    public String getDescription() { 
    	return description; 
    }
    
    public Double getPrice() { 
    	return price; 
    }
}
