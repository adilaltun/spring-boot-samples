package com.works.ratelimiterdemo.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<ErrorResponse> requestNotPermitted(RequestNotPermitted exception,
                                                             WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                exception.getMessage(),
                LocalDateTime.now(),
                request.getDescription(false),
                "TOO_MANY_REQUEST_EXCEPTION"
        );
        return new ResponseEntity<>(response,HttpStatus.TOO_MANY_REQUESTS);
    }
}
