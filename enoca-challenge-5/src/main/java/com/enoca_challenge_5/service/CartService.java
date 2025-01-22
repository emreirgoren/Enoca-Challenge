package com.enoca_challenge_5.service;

import com.enoca_challenge_5.converter.CartConverter;
import com.enoca_challenge_5.dto.request.AddProductToCartRequest;
import com.enoca_challenge_5.dto.response.CartResponse;
import com.enoca_challenge_5.model.Cart;
import com.enoca_challenge_5.model.CartItem;
import com.enoca_challenge_5.model.Product;
import com.enoca_challenge_5.repository.CartRepository;
import com.enoca_challenge_5.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartConverter cartConverter;
    private final ProductRepository productRepository;

    public CartResponse getCart(Long customerId) {

        Cart cart = cartRepository.findByCustomerId(customerId).orElseThrow(() -> new IllegalArgumentException("cart.not.found"));

        return cartConverter.toCartResponse(cart);
    }

    public CartResponse addProduct(AddProductToCartRequest addProductToCartRequest) {

        Cart cart = cartRepository.findByCustomerId(addProductToCartRequest.getCustomerId()).orElseThrow(()-> new IllegalArgumentException("cart.not.found"));

        Product product = productRepository.findById(addProductToCartRequest.getProductId()).orElseThrow(() -> new IllegalArgumentException("product.not.found"));

        Optional<CartItem> optionalCartItem = cart.getItemList().stream().filter(item -> item.getProduct().equals(product)).findFirst();

        if(optionalCartItem.isPresent()){

            CartItem cartItem = optionalCartItem.get();

            if(addProductToCartRequest.getQuantity() > 0){
                cartItem.setQuantity(cartItem.getQuantity()+addProductToCartRequest.getQuantity());
                BigDecimal price = BigDecimal.valueOf(addProductToCartRequest.getQuantity()).multiply(product.getPrice());
                cartItem.setPrice(price.multiply(cartItem.getPrice()));
            }
        }else{
            CartItem newCartItem = new CartItem();
            newCartItem.setCart(cart);
            newCartItem.setProduct(product);
            if(addProductToCartRequest.getQuantity() > 0){
                newCartItem.setQuantity(addProductToCartRequest.getQuantity());
                newCartItem.setPrice(BigDecimal.valueOf(addProductToCartRequest.getQuantity()).multiply(product.getPrice()));
            }

            cart.getItemList().add(newCartItem);
        }

        BigDecimal totalPrice = cart.getItemList().stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        cart.setTotalPrice(totalPrice);

        cartRepository.save(cart);


        return cartConverter.toCartResponse(cart);

    }





}
