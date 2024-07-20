package com.ciit.proacademy.springboot;

import com.ciit.proacademy.springboot.controller.CourseController;

import com.ciit.proacademy.springboot.model.Course;
import com.ciit.proacademy.springboot.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseRepository courseRepository;

    private Course course;
//tryrrr
    @BeforeEach
    void setUp() {
        course = new Course();
        course.setId(1);
        course.setName("Course Name");
        course.setDescription("Course Description");
        course.setRating(4);
        course.setPrice(100.0);
        System.out.println("");
        System.out.println("");
        System.out.println("Test: " + course);
        System.out.println("");
        System.out.println("---------------------------------------------------");
        System.out.println("");
    }

    @Test
    void testGetAllCourses() throws Exception {
        given(courseRepository.findAll()).willReturn(Collections.singletonList(course));

        mockMvc.perform(get("/api/v1/courses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(course.getName()));
        System.out.println("Get all course: " + course.getName());
    }

    @Test
    void testGetCourseById() throws Exception {
        given(courseRepository.findById(anyInt())).willReturn(Optional.of(course));

        mockMvc.perform(get("/api/v1/courses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(course.getName()));
        System.out.println("Get course by ID: " + course.getName() + " Course ID: " + course.getId());
    }

    @Test
    void testCreateCourse() throws Exception {
        Course newCourse = new Course();
        newCourse.setId(2);
        newCourse.setName("New Course");
        newCourse.setDescription("New Course Description");
        newCourse.setRating(4);
        newCourse.setPrice(150.0);

        given(courseRepository.save(any(Course.class))).willReturn(newCourse);

        mockMvc.perform(post("/api/v1/courses/create-course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"New Course\",\"description\":\"New Course Description\",\"rating\":4.5,\"price\":150.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(newCourse.getName()));

        System.out.println("Create Course test: " + newCourse.getName());
    }

    @Test
    void testDeleteCourse() throws Exception {
        given(courseRepository.findById(anyInt())).willReturn(Optional.of(course));
        doNothing().when(courseRepository).delete(any(Course.class));

        mockMvc.perform(delete("/api/v1/courses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deleted").value(true));
                
        System.out.println("Delete Course: " + course.getName());
    }

    @Test
    void testUpdateCourse() throws Exception {
        given(courseRepository.findById(anyInt())).willReturn(Optional.of(course));
        given(courseRepository.save(any(Course.class))).willReturn(course);

        mockMvc.perform(put("/api/v1/courses/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Course Name\",\"description\":\"Updated Description\",\"rating\":5.0,\"price\":150.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Course Name"));
        System.out.println("Update Course test: " + course.getName());
    }
}
