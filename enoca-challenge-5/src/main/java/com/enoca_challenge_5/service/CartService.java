package com.enoca_challenge_5.service;

import com.enoca_challenge_5.converter.CartConverter;
import com.enoca_challenge_5.dto.request.CartRequest;
import com.enoca_challenge_5.dto.response.CartResponse;
import com.enoca_challenge_5.exceptions.BadRequestException;
import com.enoca_challenge_5.exceptions.ExceptionMessageConstants;
import com.enoca_challenge_5.model.Cart;
import com.enoca_challenge_5.model.Item;
import com.enoca_challenge_5.model.Product;
import com.enoca_challenge_5.repository.CartRepository;
import com.enoca_challenge_5.repository.CustomerRepository;
import com.enoca_challenge_5.repository.ItemRepository;
import com.enoca_challenge_5.rules.CartRules;
import com.enoca_challenge_5.rules.CustomerRules;
import com.enoca_challenge_5.rules.ProductRules;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartRules cartRules;
    private final CartConverter cartConverter;
    private final CustomerRules customerRules;
    private final ProductRules productRules;
    private final ItemRepository itemRepository;

    public CartService(CustomerRepository customerRepository, CartRepository cartRepository, CartRules cartRules, CartConverter cartConverter, CustomerRules customerRules, ProductRules productRules, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.cartRules = cartRules;
        this.cartConverter = cartConverter;
        this.customerRules = customerRules;
        this.productRules = productRules;
        this.itemRepository = itemRepository;
    }

    public CartResponse getCart(Long customerId) {
        customerRules.checkCustomerExistById(customerId);
        return cartConverter.toCartResponse(cartRepository.findByCustomerId(customerId));
    }


    public CartResponse emptyCart(Long customerId) {
        customerRules.checkCustomerExistById(customerId);
        Cart cart = cartRepository.findByCustomerId(customerId);

        cart.getItemList().clear();
        cart.setTotalPrice(BigDecimal.ZERO);
        cartRepository.save(cart);
        return cartConverter.toCartResponse(cart);
    }

    public CartResponse addProduct(Long customerId,CartRequest cartRequest) {
        customerRules.checkCustomerExistById(customerId);

        Product product = productRules.checkProductIsExist(cartRequest.getProductId());
        Cart cart = cartRepository.findByCustomerId(customerId);

        Optional<Item> optionalItem = cart.getItemList().stream()
                .filter(item ->
                    item.getProduct().getId().equals(product.getId()) &&
                    item.getCart().getId().equals(cart.getId())
                    ).findFirst();

        if(optionalItem.isPresent()){

            Item item = optionalItem.get();
            if(item.getQuantity()+ cartRequest.getQuantity() > product.getStock()){
                throw new BadRequestException(ExceptionMessageConstants.NOT_ENOUGH_STOCK);
            }
            item.setQuantity(item.getQuantity()+cartRequest.getQuantity());
            item.setPrice(calculateItemPrice(item.getQuantity(),product.getPrice()));
            itemRepository.save(item);

        }else{
            Item newItem = new Item();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(cartRequest.getQuantity());
            newItem.setPrice(calculateItemPrice(cartRequest.getQuantity(),product.getPrice()));
            itemRepository.save(newItem);
            cart.getItemList().add(newItem);
        }

        cart.setTotalPrice(calculateCartPrice(cart));

        return cartConverter.toCartResponse(cart);
    }

    private BigDecimal calculateItemPrice(int quantity,BigDecimal price){
        return BigDecimal.valueOf(quantity).multiply(price);
    }

    private BigDecimal calculateCartPrice(Cart cart){

        return
        cart.getItemList().stream()
                .map(item -> item.getPrice())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    /**
     * Update cart
     */



}
