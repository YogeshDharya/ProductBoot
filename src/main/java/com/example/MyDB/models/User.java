package com.example.MyDB.models;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(name="name")
	private String name;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_cart_id")//Foreign key of user_cart entity managed in the owning User entity 
	private UserCart user_cart;
	
	public User() {
		
	}
	public User(Long id,String name,UserCart cartId) {
		this.id = id ;
		this.name = name;
		this.user_cart = cartId;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long newId) {
		this.id = newId;
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