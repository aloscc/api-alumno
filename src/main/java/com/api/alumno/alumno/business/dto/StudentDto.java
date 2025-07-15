package com.api.alumno.alumno.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @Positive(message = "id has to be a positive number")
    private Long id;
    @NotEmpty(message = "firstname is required")
    private String firstname;
    @NotEmpty(message = "lastname is required")
    private String lastname;
    @Positive(message = "age has to be a positive number")
    private int age;
}
