package com.enoca_challenge_5.converter;

import com.enoca_challenge_5.dto.response.CartResponse;
import com.enoca_challenge_5.model.Cart;

public class CartConverter {

    public CartResponse toCartResponse(Cart cart){

        if(cart == null){
            throw new IllegalArgumentException("cart.not.null");
        }

        var cartResponse = new CartResponse();

        cartResponse.setItemList(cart.getItemList());
        cartResponse.setTotalPrice(cart.getTotalPrice());

        return cartResponse;
    }

}
