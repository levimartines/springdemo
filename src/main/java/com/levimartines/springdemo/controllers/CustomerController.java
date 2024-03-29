package com.levimartines.springdemo.controllers;

import com.levimartines.springdemo.dtos.CustomerDTO;
import com.levimartines.springdemo.entities.Customer;
import com.levimartines.springdemo.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService service;

	@GetMapping
	public List<CustomerDTO> findAll() {
		return service.findAll();
	}

	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		customer = service.save(customer);
		return ResponseEntity.created(URI.create("/customers/" + customer.getId())).body(customer);
	}

}
