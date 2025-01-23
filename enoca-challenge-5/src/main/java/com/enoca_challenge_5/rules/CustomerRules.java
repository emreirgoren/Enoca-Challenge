package com.enoca_challenge_5.rules;

import com.enoca_challenge_5.repository.CustomerRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CustomerRules {

    private final CustomerRepository customerRepository;

    public CustomerRules(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void checkCustomerExist(String email) {

        if(customerRepository.existsByEmail(email)){
            throw new IllegalArgumentException("customer.already.exist");
        }

    }
}
