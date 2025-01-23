package com.enoca_challenge_5.service;

import com.enoca_challenge_5.converter.CustomerConverter;
import com.enoca_challenge_5.dto.request.CreateCustomerRequest;
import com.enoca_challenge_5.dto.response.CreateCustomerResponse;
import com.enoca_challenge_5.repository.CustomerRepository;
import com.enoca_challenge_5.rules.CustomerRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;
    private final CustomerRules customerRules;


    public CustomerService(CustomerRepository customerRepository, CustomerConverter customerConverter, CustomerRules customerRules) {
        this.customerRepository = customerRepository;
        this.customerConverter = customerConverter;
        this.customerRules = customerRules;
    }

    public CreateCustomerResponse createCustomer(@Valid CreateCustomerRequest createCustomerRequest) {

        customerRules.checkCustomerExist(createCustomerRequest.getEmail());

        var customer = customerConverter.toCustomer(createCustomerRequest);

        customerRepository.save(customer);

        return customerConverter.toCreateCustomerResponse(customer);

    }

}
