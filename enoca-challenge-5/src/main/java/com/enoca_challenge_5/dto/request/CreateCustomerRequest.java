package com.enoca_challenge_5.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {

    @NotNull
    @NotBlank(message = "Not be null")
    private String firstName;

    @NotNull
    @NotBlank(message = "Not be null")
    private String lastName;

    @NotNull
    @NotBlank(message = "Not be null")
    private String email;

    @NotNull
    @NotBlank(message = "Not be null")
    private String phone;

    @NotNull
    @NotBlank(message = "Not be null")
    private String address;


}
