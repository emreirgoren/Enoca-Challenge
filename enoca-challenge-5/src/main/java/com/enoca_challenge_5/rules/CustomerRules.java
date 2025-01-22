package com.enoca_challenge_5.rules;

import com.enoca_challenge_5.model.Customer;
import com.enoca_challenge_5.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRules {

    private final CustomerRepository customerRepository;

    public void checkEmailValid(String email){
        if(!email.contains("@")){
            throw new IllegalArgumentException("email.not.valid " + "Email: " + email);
        }
    }

    public void checkEmailIsExist(String email){

        if(customerRepository.findByEmail(email).isPresent()){
            throw new IllegalArgumentException("email.already.exist" + "Email: " +email);
        }

    }

}
