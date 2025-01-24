package com.enoca_challenge_5.converter;

import com.enoca_challenge_5.dto.response.CartResponse;
import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {
    public CartResponse toCartResponse(Cart cart) {

        if(cart == null){
            throw new BadRequestException(ExceptionMessageConstants.CART_NOT_FOUND);
        }
        CartResponse cartResponse = new CartResponse();

        cartResponse.setItemList(cart.getItemList());
        cartResponse.setTotalPrice(cart.getTotalPrice());
        return cartResponse;

    }
}
