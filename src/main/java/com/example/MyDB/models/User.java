//package com.example.MyDB.models;
//import java.util.List;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//@Entity
//@Table(name="User")
//public class User {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Double id;
//	
//	@Column(name="name")
//	private String name;
//	
//	@Column(name="user_password")
//	private String password;
//	
//	@Column(name="user_cart")
//	private List<Double> Cart;
//	
//	public User() {
//		
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getPassword() {
//		return this.password;
//	}
//	
//	public void setPassword(String Password) {
//		this.password = Password;
//	}
//
//	public List<Double> getCart() {
//		return Cart;
//	}
//
//}
//
