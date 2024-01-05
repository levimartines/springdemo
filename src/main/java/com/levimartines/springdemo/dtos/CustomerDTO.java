package com.levimartines.springdemo.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDTO {
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String address;
}
