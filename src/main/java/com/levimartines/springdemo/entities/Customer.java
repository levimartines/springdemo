package com.levimartines.springdemo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	private String email;
	@NotNull
	private String phone;
	@NotNull
	private String address;
	private String comments;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	private List<Car> cars = new ArrayList<>();

}
