package com.levimartines.springdemo.repositories;

import com.levimartines.springdemo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
