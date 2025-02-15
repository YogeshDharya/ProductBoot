package com.example.MyDB.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.MyDB.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	 Optional<Product> findById(Long productId);	 
}
