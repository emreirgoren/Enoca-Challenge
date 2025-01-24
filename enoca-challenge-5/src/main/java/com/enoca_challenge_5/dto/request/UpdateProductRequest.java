package com.enoca_challenge_5.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductRequest {
    private String description;
    private int stock;
    private BigDecimal price;
}
