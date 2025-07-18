package com.example.demo.service;

import com.example.demo.dto.EnrollmentDTO;
import com.example.demo.entity.Enrollment;

public interface EnrollementService {

	Enrollment save(EnrollmentDTO dto);

}
