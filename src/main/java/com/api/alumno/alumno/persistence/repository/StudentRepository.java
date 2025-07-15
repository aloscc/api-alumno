package com.api.alumno.alumno.persistence.repository;

import com.api.alumno.alumno.persistence.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {
    Flux<Student> findByFlgdel(int flg);
}
