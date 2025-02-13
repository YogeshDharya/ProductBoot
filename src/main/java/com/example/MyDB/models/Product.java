package com.example.MyDB.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private Double price;
	
	public Product() {
		
	}
	public Product(String name,String description,Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String newDeci) {
		this.description = newDeci;
	}
	public Double getPrice() {
		return this.price;
	}
	public void setPrice(Double newPrice) {
		this.price = newPrice;
	}
}
