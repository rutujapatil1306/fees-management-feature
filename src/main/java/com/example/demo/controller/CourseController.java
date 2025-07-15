package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/course")
	public ResponseEntity saveCourse(@RequestBody Course course) {
		try {
			Course savedCourse = courseService.saveCourse(course);
			return new ResponseEntity(savedCourse,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	 @GetMapping("/syllabus/{id}")
	    public ResponseEntity<String> getSyllabus(@PathVariable Integer id) {
	        Course c = courseRepository.findById(id).orElse(null);
	        if (c == null) return ResponseEntity.notFound().build();

	        String path = "C:/syllabus/" + c.getCourseName() + "/" + c.getSyllabus();
	        return ResponseEntity.ok("Syllabus path: " + path);
	    }
}
