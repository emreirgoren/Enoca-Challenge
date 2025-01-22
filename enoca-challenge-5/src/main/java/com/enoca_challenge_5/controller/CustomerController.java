package com.enoca_challenge_5.controller;

import com.enoca_challenge_5.dto.request.CreateCustomerRequest;
import com.enoca_challenge_5.dto.response.CreateCustomerResponse;
import com.enoca_challenge_5.model.Customer;
import com.enoca_challenge_5.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    private ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        log.debug("REST request create customer");
        return customerService.createCustomer(createCustomerRequest);
    }


}
