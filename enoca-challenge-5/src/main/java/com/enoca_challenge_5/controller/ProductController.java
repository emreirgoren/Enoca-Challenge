package com.enoca_challenge_5.controller;

import com.enoca_challenge_5.dto.request.CreateProductRequest;
import com.enoca_challenge_5.dto.response.ProductResponse;
import com.enoca_challenge_5.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest){
        return ResponseEntity.ok(productService.createProduct(createProductRequest));
    }

}
