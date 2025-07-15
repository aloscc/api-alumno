package com.api.alumno.alumno.business.mapper;

import com.api.alumno.alumno.business.dto.StudentDto;
import com.api.alumno.alumno.persistence.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapperImpl implements StudentMapper {
    @Override
    public StudentDto entityToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setAge(student.getAge());
        studentDto.setFirstname(student.getFirstname());
        studentDto.setLastname(student.getLastname());
        return studentDto;
    }

    @Override
    public Student dtoToEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setAge(studentDto.getAge());
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        return student;
    }
}
