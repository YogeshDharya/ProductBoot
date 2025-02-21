package com.example.MyDB.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_cart")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class UserCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_cart_id")
	private Long user_cart_id;
	
	@OneToOne(mappedBy ="user_cart" ,cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JsonBackReference
	private User user;

	@ManyToMany( 
			cascade={ 
				CascadeType.PERSIST, 
				CascadeType.MERGE }, 
			fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_cart_products", 
			joinColumns = @JoinColumn(name = "user_cart_id"), 
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	@JsonManagedReference
	private List<Product> products ;
	
	public UserCart() {
		this.products= new ArrayList<>();
	}
	public UserCart(User usr) {
		this.user = usr;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public Long getId() {
		return this.user_cart_id;
	}
	public void setId(Long newId) {
		this.user_cart_id = newId;
	}
}
//----------------------------------------------------------------------------