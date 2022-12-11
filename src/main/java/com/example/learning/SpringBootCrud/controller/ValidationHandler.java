package com.example.learning.SpringBootCrud.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.learning.SpringBootCrud.uniformResponse.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiResponse apiResponse= new ApiResponse();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            apiResponse.setError(message);
            apiResponse.setStatus(400);

            //apiResponse.setError(errors.put(fieldName, message));

        });
        return new ResponseEntity<Object>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}