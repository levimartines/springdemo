package com.levimartines.springdemo.repositories;

import com.levimartines.springdemo.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

	@Query("SELECT c FROM Car c " +
		"INNER JOIN FETCH c.customer " +
		"LEFT JOIN c.estimates e " +
		"LEFT JOIN e.items " +
		"WHERE UPPER(c.plate) = UPPER(?1) ")
	Optional<Car> findByPlate(String plate);

	@Query("SELECT c FROM Car c " +
		"INNER JOIN FETCH c.customer " +
		"LEFT JOIN c.estimates e " +
		"LEFT JOIN e.items " +
		"WHERE c.id = ?1")
	Optional<Car> findById(Long id);
}
