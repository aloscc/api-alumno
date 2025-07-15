package com.api.alumno.alumno.presentation.controller;

import com.api.alumno.alumno.business.dto.StudentDto;
import com.api.alumno.alumno.business.service.StudentService;
import com.api.alumno.alumno.exception.StudentExistException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/students")
@Validated
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<StudentDto> list() {
        return service.list();
    }

    @PostMapping
    public Mono<StudentDto> create(@Valid @RequestBody StudentDto student) {
        return service.create(student);
    }

    @ExceptionHandler(StudentExistException.class)
    public Mono<ResponseEntity<String>> handleResourceNotFoundException(StudentExistException ex) {
        return Mono.just(new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
