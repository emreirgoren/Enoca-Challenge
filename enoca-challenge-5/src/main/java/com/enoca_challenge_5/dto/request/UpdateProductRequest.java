package com.enoca_challenge_5.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductRequest {

    private String productName;

    private String description;

    private BigDecimal price;

    private int stock;

}
