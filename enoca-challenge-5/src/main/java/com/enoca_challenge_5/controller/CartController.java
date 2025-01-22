package com.enoca_challenge_5.controller;

import com.enoca_challenge_5.dto.request.AddProductToCartRequest;
import com.enoca_challenge_5.dto.response.CartResponse;
import com.enoca_challenge_5.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CartResponse> getCart(@PathVariable Long customerId){
        log.debug("REST get cart");
        return ResponseEntity.ok(cartService.getCart(customerId));
    }

    @PostMapping("/add")
    public ResponseEntity<CartResponse> addProduct(@RequestBody AddProductToCartRequest addProductToCartRequest){
        log.debug("REST add product");
        return ResponseEntity.ok(cartService.addProduct(addProductToCartRequest));
    }


}
