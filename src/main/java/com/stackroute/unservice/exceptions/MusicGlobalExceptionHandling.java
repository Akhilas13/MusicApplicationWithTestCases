package com.stackroute.unservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MusicGlobalExceptionHandling extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = MusicNotFoundException.class)
    public ResponseEntity<Object> exception(MusicNotFoundException exception)
    {
        return new ResponseEntity<>("Music not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MusicAlreadyExistsException.class)
    public ResponseEntity<Object> exception(MusicAlreadyExistsException exception)
    {
        return new ResponseEntity<>("Music Already exists", HttpStatus.NOT_FOUND);
    }




}
