package com.ciit.proacademy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciit.proacademy.springboot.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
