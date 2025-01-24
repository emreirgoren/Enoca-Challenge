package com.enoca_challenge_5.repository;

import com.enoca_challenge_5.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
