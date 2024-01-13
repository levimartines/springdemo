package com.levimartines.springdemo.controllers;

import com.levimartines.springdemo.services.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/estimates")
@RestController
@RequiredArgsConstructor
public class EstimateController {

	private final EstimateService service;

	@GetMapping("/{id}/download")
	public ResponseEntity<byte[]> find(@PathVariable("id") Long id) {
		byte[] pdfBytes = service.generateEstimatePdf(id);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	}

}
