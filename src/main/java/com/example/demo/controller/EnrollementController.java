package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EnrollmentDTO;
import com.example.demo.entity.Enrollment;
import com.example.demo.service.EnrollementService;

@RestController
public class EnrollementController {
	
	@Autowired
	EnrollementService enrollementService;
	
	@PostMapping("/enroll")
	public ResponseEntity saveEnrollment(@RequestBody EnrollmentDTO dto) {
	    try {
	        Enrollment savedEnrollment = enrollementService.save(dto);
	        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}

	
}
