package com.enoca_challenge_5.service;

import com.enoca_challenge_5.converter.ProductConverter;
import com.enoca_challenge_5.dto.request.CreateProductRequest;
import com.enoca_challenge_5.dto.request.UpdateProductRequest;
import com.enoca_challenge_5.dto.response.GenericResponse;
import com.enoca_challenge_5.dto.response.GenericResponseConstants;
import com.enoca_challenge_5.dto.response.ProductResponse;
import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Product;
import com.enoca_challenge_5.repository.ProductRepository;
import com.enoca_challenge_5.rules.ProductRules;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRules productRules;
    private final ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductRules productRules, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productRules = productRules;
        this.productConverter = productConverter;
    }

    public ProductResponse getProduct(Long productId) {
        Product product = productRules.checkProductIsExist(productId);
        return productConverter.toProductResponse(product);
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        productRules.checkProductIsExistByName(createProductRequest.getProductName());
        var newProduct = productConverter.toProduct(createProductRequest);
        productRepository.save(newProduct);
        return productConverter.toProductResponse(newProduct);
    }

    public ProductResponse updateProduct(Long productId,UpdateProductRequest updateProductRequest) {

        Product product = productRules.checkProductIsExist(productId);

        product.setDescription(updateProductRequest.getDescription());
        product.setStock(updateProductRequest.getStock());
        product.setPrice(updateProductRequest.getPrice());
        productRepository.save(product);

        return productConverter.toProductResponse(product);
    }

    public GenericResponse deleteProduct(Long productId) {

        productRules.checkProductIsExist(productId);
        productRepository.deleteById(productId);

        return GenericResponse.success(GenericResponseConstants.DELETE_PRODUCT_SUCCESS);
    }
}
