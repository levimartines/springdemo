package com.levimartines.springdemo.controller;

import com.levimartines.springdemo.BaseIntegrationTest;
import com.levimartines.springdemo.dtos.CarDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CarControllerTest extends BaseIntegrationTest {

	@Nested
	class Find {

		@Test
		void shouldReturn404WhenCarIsNotFound() {
			ResponseEntity<CarDTO> response = template.getForEntity("/cars?plate=AAA999", CarDTO.class);
			assertEquals(200, response.getStatusCode().value());
			assertNull(response.getBody());
		}
	}
}
