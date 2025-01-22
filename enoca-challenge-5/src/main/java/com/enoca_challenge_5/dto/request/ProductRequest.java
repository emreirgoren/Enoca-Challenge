package com.enoca_challenge_5.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    @NotBlank
    @NotNull(message = "Not null")
    private String productName;

    @NotBlank
    @NotNull(message = "Not null")
    private String description;

    @NotBlank
    @NotNull(message = "Not null")
    private BigDecimal price;

    @NotBlank
    @NotNull(message = "Not null")
    private int stock;

}
