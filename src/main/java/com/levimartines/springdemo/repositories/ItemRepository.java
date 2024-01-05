package com.levimartines.springdemo.repositories;

import com.levimartines.springdemo.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
