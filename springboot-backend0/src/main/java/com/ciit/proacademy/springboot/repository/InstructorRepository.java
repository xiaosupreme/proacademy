package com.ciit.proacademy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciit.proacademy.springboot.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
