package com.levimartines.springdemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private String color;
	private String comments;
	private String plate;

	@ManyToOne
	@JoinColumn(name = "customer_id", updatable = false)
	private Customer customer;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	private List<Estimate> estimates = new ArrayList<>();

}
