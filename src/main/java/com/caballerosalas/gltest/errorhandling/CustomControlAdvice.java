package com.caballerosalas.gltest.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
class CustomControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleExceptions(
            Exception e
    ) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage()
                ),
                status
        );
    }
}