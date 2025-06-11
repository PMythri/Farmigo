package com.Project.DealerService.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Project.DealerService.dto.CartDto;
//import com.cropdeal.cart.model.Cart;

@FeignClient(name = "cart-service", url = "http://localhost:9092/cart")
public interface CartClient {
	@PostMapping("/add")
	String addToCart(@RequestBody CartDto cartDto);


}
