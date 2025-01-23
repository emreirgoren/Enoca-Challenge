package com.enoca_challenge_5.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {

    private String productName;

    private String description;

    private int stock;

    private BigDecimal price;

}
