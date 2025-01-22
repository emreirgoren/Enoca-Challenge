package com.enoca_challenge_5.converter;


import com.enoca_challenge_5.dto.request.ProductRequest;
import com.enoca_challenge_5.dto.response.ProductResponse;
import com.enoca_challenge_5.model.Product;
import jakarta.persistence.EntityNotFoundException;

public class ProductConverter {

    public static ProductResponse toProductResponse(Product product){

        if(product == null){
            throw new EntityNotFoundException("product.not.found");
        }
        var productResponse = new ProductResponse();

        productResponse.setProductName(product.getProductName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDescription(product.getDescription());

        return productResponse;

    }

    public Product toProduct(ProductRequest productRequest) {

        if(productRequest == null){
            throw new IllegalArgumentException("ProductRequest.not.null");
        }
        var product = new Product();

        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());

        return product;
    }
}
