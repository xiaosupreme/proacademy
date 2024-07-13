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
import com.ciit.proacademy.springboot.repository.InstructorRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/instructors")
public class InstructorController {
	
	@Autowired
	private InstructorRepository instructorRepository;

	// get all instructors
	@GetMapping("")
	public List<Instructor> getAllInstructors() {
		return instructorRepository.findAll();
	}
	
	// get student by id 
	@GetMapping("{id}")
	public ResponseEntity<Instructor> getCourseById(@PathVariable int id) {
		Instructor instructor = instructorRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Instructor does not exist with id:" + id));
		return ResponseEntity.ok(instructor);
	}
	
	// create instructor
	@PostMapping("/create-instructor")
	Instructor createStudent(@RequestBody Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	// delete instructor
	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, Boolean>> deleteInstructor(@PathVariable int id){
		Instructor instructor = instructorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not exist with id :" + id));
		
		instructorRepository.delete(instructor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	// update instructor
	@PutMapping("/{id}")                                                                                                     
	public ResponseEntity<Instructor> updateInstructor(@PathVariable int id, @RequestBody Instructor instructorDetails){
		
		Instructor instructor = instructorRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Instructor does not exist with id:" + id));
		
		instructor.setFirst_name(instructorDetails.getFirst_name());
		instructor.setLast_name(instructorDetails.getLast_name());
		instructor.setRating(instructorDetails.getRating());
		
		Instructor updatedInstructor = instructorRepository.save(instructor);
		return ResponseEntity.ok(updatedInstructor);
	}
	
	

}
