package com.enoca_challenge_5.repository;

import com.enoca_challenge_5.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
