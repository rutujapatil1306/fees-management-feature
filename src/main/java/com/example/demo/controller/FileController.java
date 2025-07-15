package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

@RestController
public class FileController {

    @Autowired
    private CourseRepository courseRepo;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/uploadSyllabus")
    public ResponseEntity<String> uploadSyllabus(@RequestParam Integer courseId, @RequestParam MultipartFile file) {
    	 try {
    	        Optional<Course> optionalCourse = courseRepo.findBycId(courseId);
    	        if (optionalCourse.isEmpty()) {
    	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found with ID: " + courseId);
    	        }

    	        Course course = optionalCourse.get();

    	        // Create folder with course name
    	        String folder = uploadDir + File.separator + course.getCourseName() + File.separator;
    	        File directory = new File(folder);
    	        if (!directory.exists() && !directory.mkdirs()) {
    	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create directory for syllabus");
    	        }

    	        // Save file to path
    	        String filePath = folder + file.getOriginalFilename();
    	        file.transferTo(new File(filePath));

    	        // Save syllabus name in DB
    	        course.setSyllabus(file.getOriginalFilename());
    	        courseRepo.save(course);

    	        return ResponseEntity.ok("Syllabus uploaded successfully for course: " + course.getCourseName());

    	    } catch (IOException e) {
    	        e.printStackTrace();
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed due to IO Error");
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
    	    }
    	}
}