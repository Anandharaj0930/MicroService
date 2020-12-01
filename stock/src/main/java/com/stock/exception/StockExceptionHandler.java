package com.stock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StockExceptionHandler {

    @ExceptionHandler(StockCreateException.class)
    @ResponseStatus(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
    public void createStockException() {
    }

    @ExceptionHandler(StockGetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void getStockException() {
    }
}
