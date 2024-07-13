package com.ciit.proacademy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciit.proacademy.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
