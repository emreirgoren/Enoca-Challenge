package com.enoca_challenge_5.rules;

import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Product;
import com.enoca_challenge_5.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductRules {

    private final ProductRepository productRepository;

    public ProductRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product checkProductIsExist(Long productId) {
        if(productId != null){
            productRepository.findById(productId).orElseThrow(()-> new BadRequestException(ExceptionMessageConstants.PRODUCT_NOT_FOUND));
        }
        return productRepository.findById(productId).get();
    }
}
