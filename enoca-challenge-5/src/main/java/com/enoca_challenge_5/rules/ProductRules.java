package com.enoca_challenge_5.rules;

import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Product;
import com.enoca_challenge_5.repository.ProductRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ProductRules {

    private final ProductRepository productRepository;

    public ProductRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product checkProductIsExist(Long productId) {
        if(!productRepository.existsById(productId)){
            throw new BadRequestException(ExceptionMessageConstants.PRODUCT_NOT_FOUND);
        }
        return productRepository.findById(productId).get();
    }

    public void checkProductIsExistByName(String productName) {

        if(productRepository.findByProductName(productName).isPresent()){
            throw new BadRequestException(ExceptionMessageConstants.PRODUCT_ALREADY_EXIST);
        }

    }
}
