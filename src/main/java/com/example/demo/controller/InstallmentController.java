package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Response.Response;
import com.example.demo.dto.InstallmentRequestDto;
import com.example.demo.entity.Installment;
import com.example.demo.service.InstallmentService;

@RestController
public class InstallmentController {
	
	@Autowired
	InstallmentService installmentService;
	
	@PostMapping("/installments/create")
	public ResponseEntity<Response> createInstallments(@RequestBody InstallmentRequestDto dto) {
	    try {
	        List<Installment> savedInstallments = installmentService.saveInstallments(dto);
	        Response response = new Response("Installments created successfully", savedInstallments, true);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        Response response = new Response("Failed to create installments: " + e.getMessage(), null, false);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
}
