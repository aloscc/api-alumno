package com.api.alumno.alumno.exception;

public class StudentExistException extends RuntimeException {
    public StudentExistException(String message) {
        super(message);
    }
}
