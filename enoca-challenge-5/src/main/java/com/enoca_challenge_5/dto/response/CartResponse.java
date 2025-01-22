package com.enoca_challenge_5.dto.response;

import com.enoca_challenge_5.model.Cart;
import com.enoca_challenge_5.model.CartItem;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartResponse {

    private List<CartItem> itemList;

    private BigDecimal totalPrice;

}
