package com.levimartines.springdemo.services;

import com.levimartines.springdemo.dtos.CarDTO;
import com.levimartines.springdemo.dtos.EstimateDTO;
import com.levimartines.springdemo.dtos.ItemDTO;
import com.levimartines.springdemo.entities.Car;
import com.levimartines.springdemo.entities.Estimate;
import com.levimartines.springdemo.entities.Item;
import com.levimartines.springdemo.repositories.CarRepository;

import com.levimartines.springdemo.repositories.EstimateRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CarService {

	private final CarRepository repository;
	private final EstimateRepository estimateRepository;
	private final ModelMapper mapper;


	public CarDTO findById(Long id) {
		Optional<Car> car = repository.findById(id);
		return car.map(value -> mapper.map(value, CarDTO.class)).orElse(null);
	}

	public CarDTO findByPlate(String plate) {
		Optional<Car> car = repository.findByPlate(plate);
		return car.map(value -> mapper.map(value, CarDTO.class)).orElse(null);
	}

	public CarDTO save(CarDTO dto) {
		Car car = mapper.map(dto, Car.class);
		repository.save(car);
		return mapper.map(car, CarDTO.class);
	}

	public CarDTO find(Long id, String plate) {
		if (id == null) {
			return findByPlate(plate);
		}
		return findById(id);
	}

	@Transactional
	public EstimateDTO addEstimate(Long id, List<ItemDTO> items) {
		Optional<Car> car = repository.findById(id);
		if (car.isEmpty()) {
			return null;
		}
		Estimate estimate = new Estimate();
		estimate.setCar(car.get());
		estimate.setItems(items.stream().map(item -> mapper.map(item, Item.class)).toList());
		estimate.getItems().forEach(item -> item.setEstimate(estimate));
		estimateRepository.save(estimate);

		return mapper.map(estimate, EstimateDTO.class);
	}
}
