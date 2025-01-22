package com.enoca_challenge_5.controller;

import com.enoca_challenge_5.dto.request.ProductRequest;
import com.enoca_challenge_5.dto.request.UpdateProductRequest;
import com.enoca_challenge_5.dto.response.ProductResponse;
import com.enoca_challenge_5.model.Product;
import com.enoca_challenge_5.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getProduct")
    public ResponseEntity<ProductResponse> getProduct(@RequestParam Long id){
        log.debug("REST get product");
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest){
        log.debug("REST create product");
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest){
        log.debug("REST update product");
        return ResponseEntity.ok(productService.updateProduct(id,updateProductRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        log.debug("REST delete product");
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted");
    }

}
