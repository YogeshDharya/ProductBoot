package com.example.MyDB.utility;

public class CustomResponse {
//Body, status, Headers 
	private Long id;
	private String name;
	private String description;
	private Double price;
	public CustomResponse(Long id, String name, String description, Double price) {
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
