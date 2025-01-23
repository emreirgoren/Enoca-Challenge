package com.enoca_challenge_5.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank
    @NotNull(message = "Product name cannot be null")
    private String productName;

    private String description;

    @NotNull(message = "Product stock cannot be null")
    private int stock;

    @NotNull(message = "Product price cannot be null")
    private BigDecimal price;

}
