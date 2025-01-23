package com.enoca_challenge_5.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {

    @NotBlank
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotBlank
    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotBlank
    @NotNull(message = "Email cannot be null")
    private String email;

    private String address;

}
