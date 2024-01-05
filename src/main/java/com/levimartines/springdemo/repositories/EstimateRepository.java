package com.levimartines.springdemo.repositories;

import com.levimartines.springdemo.entities.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {
}
