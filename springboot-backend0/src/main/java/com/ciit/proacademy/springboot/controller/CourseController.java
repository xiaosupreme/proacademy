package com.ciit.proacademy.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciit.proacademy.springboot.exception.ResourceNotFoundException;
import com.ciit.proacademy.springboot.model.Course;
import com.ciit.proacademy.springboot.model.Instructor;
import com.ciit.proacademy.springboot.model.Student;
import com.ciit.proacademy.springboot.repository.CourseRepository;
import com.ciit.proacademy.springboot.repository.InstructorRepository;
import com.ciit.proacademy.springboot.repository.StudentRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/courses")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;

	// get all students enrolled
	@GetMapping("")
	public List<Course> getAllStudents() {
		return courseRepository.findAll();
	}
	
	// get course by id 
	@GetMapping("{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable int id) {
		Course course = courseRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Course does not exist with id:" + id));
		return ResponseEntity.ok(course);
	}
	
	// create course
	@PostMapping("/create-course")
	Course createStudent(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	// delete course
	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable int id){
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));
		
		courseRepository.delete(course);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// update course
	@PutMapping("/{id}")                                                                                                     
	public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course courseDetails){
		
		Course course = courseRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Course does not exist with id:" + id));
		
		course.setName(courseDetails.getName());
		course.setDescription(courseDetails.getDescription());
		course.setRating(courseDetails.getRating());
		course.setPrice(courseDetails.getPrice());
		
		Course updatedCourse = courseRepository.save(course);
		return ResponseEntity.ok(updatedCourse);
	}
	
	// put student to course (enroll student)
	// many-to-many relationship
	@PutMapping("/{courseId}/students/{studentId}")
	Course enrollStudentToCourse(@PathVariable int courseId, @PathVariable int studentId) {
		
		Course course = courseRepository.findById(courseId).get();
		Student student = studentRepository.findById(studentId).get();
		
		course.getEnrolledStudents().add(student);
		
		return courseRepository.save(course);
	}
	
	// put instructor to course (assign course)
	// one-to-many relationship
	@PutMapping("/{courseId}/instructor/{instructorId}")
	Course assignInstructorToCourse(@PathVariable int courseId, @PathVariable int instructorId) {
		
		Course course = courseRepository.findById(courseId).get();
		Instructor instructor = instructorRepository.findById(instructorId).get();
		
		course.setInstructor(instructor);
		
		return courseRepository.save(course);
	}

}
