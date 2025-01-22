package com.enoca_challenge_5.service;

import com.enoca_challenge_5.converter.ProductConverter;
import com.enoca_challenge_5.dto.request.ProductRequest;
import com.enoca_challenge_5.dto.request.UpdateProductRequest;
import com.enoca_challenge_5.dto.response.ProductResponse;
import com.enoca_challenge_5.model.Product;
import com.enoca_challenge_5.repository.ProductRepository;
import com.enoca_challenge_5.rules.ProductRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRules productRules;
    private final ProductConverter productConverter;
    public ProductResponse getProduct(Long id){
        return ProductConverter.toProductResponse(productRepository.findById(id).get());
    }
    public ProductResponse createProduct(ProductRequest productRequest) {
        productRules.checkProductExistByName(productRequest.getProductName());
        var newProduct = productConverter.toProduct(productRequest);
        productRepository.save(newProduct);
        return productConverter.toProductResponse(newProduct);
    }

    public ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest) {

        var product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("product.not.found"));

        if(!updateProductRequest.getProductName().isEmpty()){
            product.setProductName(updateProductRequest.getProductName());
        }
        if(!updateProductRequest.getDescription().isEmpty()){
            product.setDescription(updateProductRequest.getDescription());
        }
        if(updateProductRequest.getPrice() != null){
            product.setPrice(updateProductRequest.getPrice());
        }
        if(Objects.nonNull(updateProductRequest.getStock())){
            product.setStock(updateProductRequest.getStock());
        }

        return productConverter.toProductResponse(product);

    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("product.not.found"));
        productRepository.deleteById(id);
    }
}
