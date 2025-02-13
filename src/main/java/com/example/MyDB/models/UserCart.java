//package com.example.MyDB.models;
//
//import java.util.List;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="user_cart")
//public class UserCart {
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	
//	@ManyToOne
//	@JoinColumn(name="user")
//	private Long userId;
//
//	@ManyToOne
//	@JoinColumn(name="user_products")
//	private List<Product> products;
//	
//}
