package com.api.alumno.alumno.business.mapper;

import com.api.alumno.alumno.business.dto.StudentDto;
import com.api.alumno.alumno.persistence.model.Student;

public interface StudentMapper {
    StudentDto entityToDto(Student student);

    Student dtoToEntity(StudentDto studentDto);
}
