package com.cropdeal.cart.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.Crop.model.Crop;
import com.cropdeal.cart.dto.CartDto;
import com.cropdeal.cart.model.Cart;
import com.cropdeal.cart.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

	        @Autowired
	        private CartRepository cartRepository;

	        public String addToCart(CartDto cartDto) {
	            Optional<Cart> existingCart = cartRepository.findByUserId(cartDto.getUserId());

	            Cart cart;
	            if (existingCart.isPresent()) {
	                cart = existingCart.get();
	                cart.getSelectedCrops().addAll(cartDto.getSelectedCrops());
	                cart.setTotalPrice(cart.getTotalPrice() + cartDto.getTotalPrice());
	            } else {
	                cart = new Cart(cartDto.getUserId(), cartDto.getSelectedCrops(), cartDto.getTotalPrice());
	            }

	            cartRepository.save(cart);
	            return "Crops added to cart successfully!";
	        }

	        public CartDto getCartByUserId(Integer userId) {
	            Cart cart = cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));

	            CartDto cartDto = new CartDto();
	            cartDto.setUserId(cart.getUserId());
	            cartDto.setSelectedCrops(cart.getSelectedCrops());
	            cartDto.setTotalPrice(cart.getTotalPrice());

	            return cartDto;
	        }

	        public String deleteCartByUserId(Integer userId) {
	            Optional<Cart> cart = cartRepository.findByUserId(userId);
	            if (cart.isPresent()) {
	                cartRepository.delete(cart.get());
	                return "Cart deleted successfully!";
	            } else {
	                throw new RuntimeException("Cart not found for user ID: " + userId);
	            }
	        }

	    }