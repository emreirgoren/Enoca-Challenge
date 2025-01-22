package com.enoca_challenge_5.dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {

    private String productName;

    private String description;

    private BigDecimal price;

}
