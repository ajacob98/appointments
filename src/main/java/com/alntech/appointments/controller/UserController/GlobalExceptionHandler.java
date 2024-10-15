package com.alntech.appointments.controller.UserController;

import com.alntech.appointments.service.exceptions.UserAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExists e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
