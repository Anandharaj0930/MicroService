package com.customer.exception;

import com.customer.types.CustomerResponse;
import com.customer.types.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerCoreException.class)
    public CustomerResponse cutomerPersistException() {
        CustomerResponse response = new CustomerResponse();
        Error error = new Error();
        error.setStatusMsg("KO");
        error.setStatusCode("400");
        response.setError(error);
        return response;
    }

    @ExceptionHandler(CustomerGetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void cutomerGetException() {

    }

    @ExceptionHandler(CustomerExternalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void cutomerExternalException() {
    }
}
