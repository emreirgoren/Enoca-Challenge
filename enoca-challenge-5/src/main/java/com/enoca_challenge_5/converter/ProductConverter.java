package com.enoca_challenge_5.converter;

import com.enoca_challenge_5.dto.request.CreateProductRequest;
import com.enoca_challenge_5.dto.response.ProductResponse;
import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductResponse toProductResponse(Product product) {

        if(product == null){
            throw new BadRequestException(ExceptionMessageConstants.PRODUCT_NULL);
        }
        var productResponse = new ProductResponse();
        productResponse.setProductName(product.getProductName());
        productResponse.setDescription(product.getDescription());
        productResponse.setStock(product.getStock());
        productResponse.setPrice(product.getPrice());

        return productResponse;
    }

    public Product toProduct(CreateProductRequest createProductRequest) {

        if(createProductRequest == null){
            throw new BadRequestException(ExceptionMessageConstants.REQUEST_NULL);
        }

        var product = new Product();
        product.setProductName(createProductRequest.getProductName());
        product.setDescription(createProductRequest.getDescription());
        product.setStock(createProductRequest.getStock());
        product.setPrice(createProductRequest.getPrice());
        return product;
    }
}
