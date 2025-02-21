package com.example.MyDB.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Double price;

	@ManyToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	private List<UserCart> userCarts;

	@Transient
	private List<Long> userCartIds;

	public Product() {
		this.userCarts = new ArrayList<>();
	}

	public Product(String name, String description, Double price) {
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

	public List<UserCart> getUserCarts() {
		return this.userCarts;
	}

	public void setUserCarts(List<UserCart> newUserCart) {
		this.userCarts = newUserCart;
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
//----------------------------------------------