package com.api.alumno.alumno.business.service.impl;

import com.api.alumno.alumno.business.dto.StudentDto;
import com.api.alumno.alumno.business.mapper.StudentMapper;
import com.api.alumno.alumno.business.mapper.StudentMapperImpl;
import com.api.alumno.alumno.business.service.StudentService;
import com.api.alumno.alumno.persistence.model.Student;
import com.api.alumno.alumno.persistence.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class StudentServiceImplTest {
    @Mock
    StudentRepository studentRepository;

    private StudentMapper studentMapper;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentMapper = new StudentMapperImpl();
        studentService = new StudentServiceImpl(studentRepository, studentMapper);
    }

    @Test
    void listTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L, "Maria2", "Aguirre", 23));
        studentList.add(new Student(2L, "Carlos", "Acero", 22));
        studentList.add(new Student(3L, "Marco", "Nieves", 24));
        studentList.add(new Student(4L, "Julia", "Correa", 21));

        when(studentRepository.findByFlgdel(0)).thenReturn(Flux.fromIterable(studentList));

        Flux<StudentDto> list = studentService.list();

        StepVerifier
                .create(list)
                .expectNextCount(4)
                .verifyComplete();

    }

    @Test
    void createTest() {

        Student student = new Student(10L, "Maria2", "Aguirre", 23);
        StudentDto studentDto = studentMapper.entityToDto(student);

        when(studentRepository.existsById(10L)).thenReturn(Mono.just(Boolean.FALSE));
        when(studentRepository.save(student)).thenReturn(Mono.just(student));

        Mono<StudentDto> studentDtoMono = studentService.create(studentDto);

        StepVerifier
                .create(studentDtoMono)
                .expectNextCount(1)
                .verifyComplete();

    }

    @Test
    void createTestError() {

        Student student = new Student(1L, "Maria2", "Aguirre", 23);
        StudentDto studentDto = studentMapper.entityToDto(student);

        when(studentRepository.existsById(1L)).thenReturn(Mono.just(Boolean.TRUE));
        when(studentRepository.save(student)).thenReturn(Mono.just(student));

        Mono<StudentDto> studentDtoMono = studentService.create(studentDto);

        StepVerifier
                .create(studentDtoMono)
                .expectError()
                .verify();

    }

}