package com.phonebook.manager.backend.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>>  handleConstraintViolation(ConstraintViolationException exception){
        Map<String,String> errors=new LinkedHashMap<>();  //to maintain the order i have used LinkedHashMap

        Set<ConstraintViolation<?>> constraintViolations =exception.getConstraintViolations();

        constraintViolations.forEach(constraintViolation -> {
            String name=constraintViolation.getPropertyPath().toString();
           String msg=constraintViolation.getMessage();
           errors.put(name,msg);
        });

        return  new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
 }
