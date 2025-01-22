package com.enoca_challenge_5.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;


}
