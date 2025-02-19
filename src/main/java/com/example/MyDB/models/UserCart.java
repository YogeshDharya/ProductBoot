package com.example.MyDB.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

@Entity
@Table(name="user_cart")
public class UserCart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_cart_id")
	private Long user_cart_id;

	@Column(name="user_carts")
	private List<Long> user_carts;

	@ManyToMany
	@JoinTable(
			name="user_cart_products",
			joinColumns = @JoinColumn(name="user_cart_id"),
			inverseJoinColumns = @JoinColumn(name="product_id")
			)
	private List<Long> products;	
	
	public UserCart() {
		this.user_carts = new ArrayList<>();
		this.products = new ArrayList<>();
	}
	public List<Long> getProducts(){
		return this.products;
	}
	
	public List<Long> getUserCarts(){
		return this.user_carts;
	}
	public void setUserCarts(List<Long> newUserCarts) {
		this.user_carts = newUserCarts;
	}
	public Long getId() {
		return this.user_cart_id;
	}
}
//----------------------------------------------------------------------------