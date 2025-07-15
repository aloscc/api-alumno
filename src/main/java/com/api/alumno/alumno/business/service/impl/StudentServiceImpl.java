package com.api.alumno.alumno.business.service.impl;

import com.api.alumno.alumno.business.dto.StudentDto;
import com.api.alumno.alumno.business.mapper.StudentMapper;
import com.api.alumno.alumno.business.service.StudentService;
import com.api.alumno.alumno.exception.StudentExistException;
import com.api.alumno.alumno.persistence.model.Student;
import com.api.alumno.alumno.persistence.repository.StudentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Flux<StudentDto> list() {
        return studentRepository
                .findByFlgdel(0)
                .map(studentMapper::entityToDto);
    }

    @Override
    public Mono<StudentDto> create(StudentDto studentDto) {
        Student student = studentMapper.dtoToEntity(studentDto);

        return studentRepository.existsById(studentDto.getId())
                .flatMap(existsId -> {
                    if (Boolean.FALSE.equals(existsId))
                        return studentRepository
                                .save(student)
                                .map(studentMapper::entityToDto);
                    throw new StudentExistException("Can't create student, id already exist");
                });
    }
}
