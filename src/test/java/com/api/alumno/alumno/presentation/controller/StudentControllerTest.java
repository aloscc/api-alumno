package com.api.alumno.alumno.presentation.controller;

import com.api.alumno.alumno.business.dto.StudentDto;
import com.api.alumno.alumno.business.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class StudentControllerTest {
    @Mock
    StudentService studentService;

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        webTestClient = WebTestClient.bindToController(new StudentController(studentService)).build();
    }

    @Test
    void list() {
        List<StudentDto> studentList = new ArrayList<>();
        studentList.add(new StudentDto(1L, "Maria2", "Aguirre", 23));
        studentList.add(new StudentDto(2L, "Carlos", "Acero", 22));

        when(studentService.list()).thenReturn(Flux.fromIterable(studentList));

        webTestClient.get()
                .uri("http://localhost:8080/api/students")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(StudentDto.class).contains(studentList.get(0), studentList.get(1));
    }

    @Test
    void createTest() {
        StudentDto studentDto = new StudentDto(1L, "Maria2", "Aguirre", 23);

        when(studentService.create(studentDto)).thenReturn(Mono.just(studentDto));

        webTestClient.post()
                .uri("http://localhost:8080/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(studentDto), StudentDto.class)
                .exchange()
                .expectStatus().isOk();
    }
}