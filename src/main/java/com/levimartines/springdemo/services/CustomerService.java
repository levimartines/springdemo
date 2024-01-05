package com.levimartines.springdemo.services;

import com.levimartines.springdemo.dtos.CustomerDTO;
import com.levimartines.springdemo.entities.Customer;
import com.levimartines.springdemo.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository repository;
	private final ModelMapper mapper;

	@Transactional
	public Customer save(Customer customer) {
		customer.getCars().forEach(car -> car.setCustomer(customer));
		repository.save(customer);
		return customer;
	}

	public List<CustomerDTO> findAll() {
		return repository.findAll().stream()
			.map(c -> mapper.map(c, CustomerDTO.class)).toList();
	}
}
