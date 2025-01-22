package com.enoca_challenge_5.service;

import com.enoca_challenge_5.dto.request.CreateCustomerRequest;
import com.enoca_challenge_5.dto.response.CreateCustomerResponse;
import com.enoca_challenge_5.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid CreateCustomerRequest createCustomerRequest) {

        

    customerRepository.save()


    }
}
