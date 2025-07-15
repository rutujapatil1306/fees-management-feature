package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Batch;
import com.example.demo.service.BatchService;

@RestController
public class BatchController {
	
	@Autowired
	BatchService batchService;
	
	@PostMapping("/batch")
	public ResponseEntity saveBatch(@RequestBody Batch batch) {
	    try {
	       Batch savedBatch = batchService.save(batch);
	        return new ResponseEntity<>(savedBatch, HttpStatus.CREATED); 
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500 Error
	    }
	}

}
