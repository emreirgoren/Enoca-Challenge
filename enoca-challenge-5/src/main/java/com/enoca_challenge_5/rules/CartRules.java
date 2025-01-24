package com.enoca_challenge_5.rules;

import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Cart;
import com.enoca_challenge_5.repository.CartRepository;
import org.springframework.stereotype.Component;

@Component
public class CartRules {

    private final CartRepository cartRepository;

    public CartRules(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

}
