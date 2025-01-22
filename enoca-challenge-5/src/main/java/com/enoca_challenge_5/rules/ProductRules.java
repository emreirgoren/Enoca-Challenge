package com.enoca_challenge_5.rules;

import com.enoca_challenge_5.repository.ProductRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ProductRules {

    private final ProductRepository productRepository;

    public ProductRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void checkProductExistByName(String productName) {
        if(productRepository.findByName(productName).isPresent()){
            throw new IllegalArgumentException("product.already.exist");
        }
    }

    public void checkProductExistById(Long id) {
        if(productRepository.findById(id).isPresent()){
            throw new IllegalArgumentException("product.already.exist");
        }
    }
}
