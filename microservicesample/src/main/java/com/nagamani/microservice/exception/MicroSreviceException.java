package com.nagamani.microservice.exception;

import com.nagamani.microservice.types.Error;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MicroSreviceException {

    @ExceptionHandler({MicroExternalException.class, FeignException.class})
    public ResponseEntity<Error> externalException() {
        Error message = Error.builder().code("MICRO001").message("Service Unavailable").build();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MicroCoreException.class)
    public ResponseEntity<Error> coreException() {
        Error message = Error.builder().code("MICRO002").message("Bad Request").build();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MicroPersistenceException.class)
    public ResponseEntity<Error> persistenceException() {
        Error message = Error.builder().code("MICRO003").message("Invalid Data").build();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
