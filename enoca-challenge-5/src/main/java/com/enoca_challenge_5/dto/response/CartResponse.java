package com.enoca_challenge_5.dto.response;

import com.enoca_challenge_5.model.Item;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartResponse {

    private List<Item> itemList;

    private BigDecimal totalPrice;

}
