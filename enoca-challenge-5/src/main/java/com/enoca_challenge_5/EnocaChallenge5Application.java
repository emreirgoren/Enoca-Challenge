package com.enoca_challenge_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EnocaChallenge5Application {

	public static void main(String[] args) {
		SpringApplication.run(EnocaChallenge5Application.class, args);
	}

}
