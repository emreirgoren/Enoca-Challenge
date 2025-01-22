package com.enoca_challenge_5.dto.request;

import com.enoca_challenge_5.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductToCartRequest {

    private Long customerId;

    private Long productId;

    private int quantity;

}
