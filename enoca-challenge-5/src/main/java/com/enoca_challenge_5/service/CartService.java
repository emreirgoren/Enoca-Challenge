package com.enoca_challenge_5.service;

import com.enoca_challenge_5.converter.CartConverter;
import com.enoca_challenge_5.dto.response.CartResponse;
import com.enoca_challenge_5.model.Cart;
import com.enoca_challenge_5.repository.CartRepository;
import com.enoca_challenge_5.repository.CustomerRepository;
import com.enoca_challenge_5.rules.CartRules;
import com.enoca_challenge_5.rules.CustomerRules;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartRules cartRules;
    private final CartConverter cartConverter;
    private final CustomerRules customerRules;

    public CartService(CustomerRepository customerRepository, CartRepository cartRepository, CartRules cartRules, CartConverter cartConverter, CustomerRules customerRules) {
        this.cartRepository = cartRepository;
        this.cartRules = cartRules;
        this.cartConverter = cartConverter;
        this.customerRules = customerRules;
    }

    public CartResponse getCart(Long customerId) {
        customerRules.checkCustomerExistById(customerId);
        return cartConverter.toCartResponse(cartRepository.findByCustomerId(customerId));
    }


}
