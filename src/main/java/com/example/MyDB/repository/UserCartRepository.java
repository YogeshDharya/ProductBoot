package com.example.MyDB.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MyDB.models.UserCart;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart,Long>
{
	Optional<UserCart> findById(Long userCartId);
}
