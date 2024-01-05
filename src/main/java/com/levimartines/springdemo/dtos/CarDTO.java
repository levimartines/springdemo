package com.levimartines.springdemo.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CarDTO {
	private Long id;
	private String model;
	private String color;
	private String comments;
	private String plate;
	private CustomerDTO customer;
	private List<EstimateDTO> services = new ArrayList<>();
}
