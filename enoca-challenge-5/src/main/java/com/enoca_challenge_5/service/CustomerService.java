package com.enoca_challenge_5.service;

import com.enoca_challenge_5.converter.CustomerConverter;
import com.enoca_challenge_5.dto.request.CreateCustomerRequest;
import com.enoca_challenge_5.dto.response.CreateCustomerResponse;
import com.enoca_challenge_5.model.Customer;
import com.enoca_challenge_5.repository.CustomerRepository;
import com.enoca_challenge_5.rules.CustomerRules;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerRules customerRules;
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid CreateCustomerRequest createCustomerRequest){

        customerRules.checkEmailValid(createCustomerRequest.getEmail());
        customerRules.checkEmailIsExist(createCustomerRequest.getEmail());

        Customer customer = CustomerConverter.toCustomer(createCustomerRequest);
        customerRepository.save(customer);

        return ResponseEntity.ok(CustomerConverter.toCreateCustomerResponse(customer));

    }
}
