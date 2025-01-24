package com.enoca_challenge_5.controller;

import com.enoca_challenge_5.dto.request.CartRequest;
import com.enoca_challenge_5.dto.response.CartResponse;
import com.enoca_challenge_5.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CartResponse> getCart(@PathVariable Long customerId){
        return ResponseEntity.ok(cartService.getCart(customerId));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<CartResponse> emptyCart(@PathVariable Long customerId){
        return ResponseEntity.ok(cartService.emptyCart(customerId));
    }

    @PostMapping("/add/{customerId}")
    public ResponseEntity<CartResponse> addProduct(@PathVariable Long customerId,@RequestBody CartRequest cartRequest){
        return ResponseEntity.ok(cartService.addProduct(customerId,cartRequest));
    }
}
