package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EnrollmentDTO;
import com.example.demo.entity.Batch;
import com.example.demo.entity.Course;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.User;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollementRepository;
import com.example.demo.repository.UserRepository;

@Service
public class EnrollmentServiceImpl implements EnrollementService {

	@Autowired
	BatchRepository batchRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EnrollementRepository enrollementRepository;
	
	@Override
	public Enrollment save(EnrollmentDTO dto) {
		
		    User user = userRepository.findById(dto.getUserId())
		            .orElseThrow(() -> new RuntimeException("User not found"));

		    Course course = courseRepository.findById(dto.getCourseId())
		            .orElseThrow(() -> new RuntimeException("Course not found"));

		    Batch batch = batchRepository.findById(dto.getBatchId())
		            .orElseThrow(() -> new RuntimeException("Batch not found"));

		    Enrollment enrollment = new Enrollment();
		    enrollment.setEid(dto.getEid());
		    enrollment.setUser(user);
		    enrollment.setCourse(course);
		    enrollment.setBatch(batch);

		    if (dto.getEnrollmentDate() != null) {
		        enrollment.setEnrollmentDate(dto.getEnrollmentDate());
		    } else {
		        enrollment.setEnrollmentDate(LocalDate.now());
		    }

		    return enrollementRepository.save(enrollment);
		}

	}

	
	


