package com.api.alumno.alumno.persistence.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.test.StepVerifier;

@DataR2dbcTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void findByFlgdelTest() {
        studentRepository
                .findByFlgdel(0)
                .as(StepVerifier::create)
                .expectNextCount(5)
                .verifyComplete();

    }

}