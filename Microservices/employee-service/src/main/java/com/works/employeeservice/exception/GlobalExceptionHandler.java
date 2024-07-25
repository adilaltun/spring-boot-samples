package com.works.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exception,
                                                                             WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                exception.getMessage(),
                LocalDateTime.now(),
                request.getDescription(false),
                "EMPLOYEE_NOT_FOUND_EXCEPTION"
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
