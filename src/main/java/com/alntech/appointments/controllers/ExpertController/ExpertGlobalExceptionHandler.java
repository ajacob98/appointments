package com.alntech.appointments.controllers.ExpertController;

import com.alntech.appointments.commonresponsebodies.ErrorResponse;
import com.alntech.appointments.services.exceptions.UserDoesNotExist;
import com.alntech.appointments.services.exceptions.UserWithEmailAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExpertGlobalExceptionHandler {

    @ExceptionHandler(UserWithEmailAlreadyExists.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserWithEmailAlreadyExists e){
        ErrorResponse err= new ErrorResponse();
        err.setMsg(e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserDoesNotExist.class)
    public ResponseEntity<ErrorResponse> handleUserDoesNotExist(UserDoesNotExist e){
        ErrorResponse err= new ErrorResponse();
        err.setMsg(e.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
