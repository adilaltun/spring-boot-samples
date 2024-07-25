package com.works.employeeservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private String message;
    private LocalDateTime localDateTime;
    private String path;
    private String errorDescription;

}
