package com.levimartines.springdemo.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ItemDTO {
	private String name;
	private Double value;
}
