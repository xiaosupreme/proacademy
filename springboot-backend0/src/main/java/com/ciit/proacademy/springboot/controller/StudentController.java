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
import com.ciit.proacademy.springboot.model.Student;
import com.ciit.proacademy.springboot.repository.StudentRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	// get all students
	@GetMapping("")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	// get student by id 
	@GetMapping("{id}")
	public ResponseEntity<Student> getCourseById(@PathVariable int id) {
		Student student = studentRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Student does not exist with id:" + id));
		return ResponseEntity.ok(student);
	}
	
	// create student
	@PostMapping("/create-student")
	Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	// update student
	@PutMapping("/{id}")                                                                                                     
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails){
		
		Student student = studentRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Student does not exist with id:" + id));
		
		student.setFirst_name(studentDetails.getFirst_name());
		student.setLast_name(studentDetails.getLast_name());
		
		Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	// delete student
	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id){
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
