package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Course;

public interface CourseService {

	Course saveCourse(Course course);

	

}
