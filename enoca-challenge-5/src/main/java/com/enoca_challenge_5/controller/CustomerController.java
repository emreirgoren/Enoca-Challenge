package com.enoca_challenge_5.controller;

import com.enoca_challenge_5.dto.request.CreateCustomerRequest;
import com.enoca_challenge_5.dto.response.CreateCustomerResponse;
import com.enoca_challenge_5.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        //log.debug("REST create customer", createCustomerRequest);
        return ResponseEntity.ok(customerService.createCustomer(createCustomerRequest));
    }

}
