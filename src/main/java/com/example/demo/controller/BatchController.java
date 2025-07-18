package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Response.Response;
import com.example.demo.dto.BatchRequestDto;
import com.example.demo.dto.BatchWithInstallmentsResponseDTO;
import com.example.demo.entity.Batch;
import com.example.demo.service.BatchService;

@RestController
public class BatchController {
	
	@Autowired
	BatchService batchService;
	
	@PostMapping("/batch")
	public ResponseEntity createBatch(@RequestBody Batch batch) {
	    try {
	       Batch savedBatch = batchService.save(batch);
	        return new ResponseEntity<>(savedBatch, HttpStatus.CREATED); 
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500 Error
	    }
	}
	
	@PostMapping("/batch/create")
	public ResponseEntity<Response> createBatchWithInstallments(@RequestBody BatchRequestDto dto) {
	    try {
	    	BatchWithInstallmentsResponseDTO savedBatch = batchService.saveBatchWithInstallments(dto);
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(new Response("Batch and Installments created", savedBatch, true));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new Response("Error: " + e.getMessage(), null, false));
	    }
	}
	
	

}
