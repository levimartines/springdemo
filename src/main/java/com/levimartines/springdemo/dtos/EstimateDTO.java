package com.levimartines.springdemo.dtos;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EstimateDTO {
	private Long id;
	private LocalDate date;
	private List<ItemDTO> items = new ArrayList<>();
}
