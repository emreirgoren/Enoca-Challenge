package com.enoca_challenge_5.controller;

import com.enoca_challenge_5.dto.response.ProductResponse;
import com.enoca_challenge_5.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(Long productId){
        return ResponseEntity.ok(productService.getProduct(productId));
    }

}
