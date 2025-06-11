package com.cropdeal.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cropdeal.Crop.model.Crop;
import com.cropdeal.cart.dto.CartDto;
import com.cropdeal.cart.model.Cart;
import com.cropdeal.cart.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
        @PostMapping("/add")
        public ResponseEntity<String> addToCart(@RequestBody CartDto cartDto) {
            return ResponseEntity.ok(cartService.addToCart(cartDto));
        }

        @GetMapping("/{userId}")
        public ResponseEntity<CartDto> getCartByUserId(@PathVariable Integer userId) {
            return ResponseEntity.ok(cartService.getCartByUserId(userId));
        }
        @DeleteMapping("/{userId}")
        public ResponseEntity<String> deleteCartByUserId(@PathVariable Integer userId) {
            return ResponseEntity.ok(cartService.deleteCartByUserId(userId));
        }

    }