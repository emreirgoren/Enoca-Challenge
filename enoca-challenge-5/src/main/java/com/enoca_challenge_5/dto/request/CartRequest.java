package com.enoca_challenge_5.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {

    private Long productId;
    private int quantity;
    private boolean removeAll;

}
