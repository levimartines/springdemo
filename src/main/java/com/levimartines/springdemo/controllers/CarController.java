package com.levimartines.springdemo.controllers;

import com.levimartines.springdemo.dtos.CarDTO;
import com.levimartines.springdemo.dtos.EstimateDTO;
import com.levimartines.springdemo.dtos.ItemDTO;
import com.levimartines.springdemo.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/cars")
@RestController
@RequiredArgsConstructor
public class CarController {

	private final CarService service;

	@GetMapping
	public CarDTO find(@RequestParam(name = "id", required = false) Long id,
					   @RequestParam(name = "plate", required = false) String plate) {
		return service.find(id, plate);
	}

	@PostMapping
	public CarDTO save(@RequestBody CarDTO car) {
		return service.save(car);
	}

	@PostMapping("/{id}/estimates")
	public EstimateDTO createEstimate(@PathVariable ("id") Long id, @RequestBody List<ItemDTO> items) {
		return service.createEstimate(id, items);
	}

}
