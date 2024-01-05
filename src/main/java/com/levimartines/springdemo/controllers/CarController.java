package com.levimartines.springdemo.controllers;

import com.levimartines.springdemo.dtos.CarDTO;
import com.levimartines.springdemo.dtos.EstimateDTO;
import com.levimartines.springdemo.dtos.ItemDTO;
import com.levimartines.springdemo.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/cars")
@RestController
@RequiredArgsConstructor
public class CarController {

	private final CarService service;

	@GetMapping
	public CarDTO find(@Param("id") Long id, @Param("id") String plate) {
		return service.find(id, plate);
	}

	@PostMapping
	public CarDTO save(CarDTO car) {
		return service.save(car);
	}

	@PostMapping("/{id}/estimates")
	public EstimateDTO createEstimate(@PathVariable ("id") Long id, List<ItemDTO> items) {
		return service.addEstimate(id, items);
	}

}
