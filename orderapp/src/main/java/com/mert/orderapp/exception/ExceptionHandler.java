package com.mert.orderapp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandler {

	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse constraintViolationExceptionHandler(ConstraintViolationException exception) {
        return new ErrorResponse(
               new Date(),
               HttpStatus.BAD_REQUEST,
               exception.getMessage()
        );
    }
}
