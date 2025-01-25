package com.enoca_challenge_5.dto.response;

import com.enoca_challenge_5.model.Cart;
import com.enoca_challenge_5.model.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderResponse {

    private BigDecimal orderPrice;

    private String orderCode;

}
