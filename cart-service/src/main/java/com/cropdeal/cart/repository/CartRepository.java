package com.cropdeal.cart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cropdeal.cart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	 // Find cart by user ID (Dealer ID)
    Optional<Cart> findByUserId(Integer userId);

    // Retrieve all carts by user ID
    List<Cart> findAllByUserId(Integer userId);


}