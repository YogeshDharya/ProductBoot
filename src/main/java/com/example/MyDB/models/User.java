package com.example.MyDB.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_cart_id", unique = true) // Foreign key of user_cart
	@JsonManagedReference																							// entity managed in the																								// owning User entity
	private UserCart user_cart;

	public User() {

	}

	public User(Long id, String name, UserCart cartId) {
		this.id = id;
		this.name = name;
		this.user_cart = cartId;
	}
	public void setId(Long newId) {
		this.id=newId;
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
	
	public UserCart getCart() {
		return this.user_cart;
	}

	public void setCart(UserCart newCart) {
		this.user_cart = newCart;
	}
}

//---------------------------------------------