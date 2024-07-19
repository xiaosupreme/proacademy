package com.ciit.proacademy.springboot;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ciit.proacademy.springboot.controller.CourseController;
import com.ciit.proacademy.springboot.model.Course;
import com.ciit.proacademy.springboot.repository.CourseRepository;
import com.ciit.proacademy.springboot.repository.StudentRepository;
import com.ciit.proacademy.springboot.repository.InstructorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseRepository courseRepository;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private InstructorRepository instructorRepository;

    @InjectMocks
    private CourseController courseController;

    @Autowired
    private ObjectMapper objectMapper;

    private Course course;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        course = new Course();
        course.setId(1);
        course.setName("Test Course");
        course.setDescription("Test Description");
        course.setRating(5);
        course.setPrice(100.0);
    }

    @Test
    public void testGetAllCourses() throws Exception {
        when(courseRepository.findAll()).thenReturn(Collections.singletonList(course));
        mockMvc.perform(get("/api/v1/courses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(course.getName()));
    }

    @Test
    public void testGetCourseById() throws Exception {
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));
        mockMvc.perform(get("/api/v1/courses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(course.getName()));
    }

    @Test
    public void testCreateCourse() throws Exception {
        when(courseRepository.save(any(Course.class))).thenReturn(course);
        mockMvc.perform(post("/api/v1/courses/create-course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(course)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(course.getName()));
    }

    @Test
    public void testDeleteCourse() throws Exception {
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));
        mockMvc.perform(delete("/api/v1/courses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deleted").value(true));
    }

    @Test
    public void testUpdateCourse() throws Exception {
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        course.setName("Updated Name");
        mockMvc.perform(put("/api/v1/courses/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(course)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }
}
