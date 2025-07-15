package com.api.alumno.alumno.business.service;

import com.api.alumno.alumno.business.dto.StudentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
    Flux<StudentDto> list();

    Mono<StudentDto> create(StudentDto student);
}
