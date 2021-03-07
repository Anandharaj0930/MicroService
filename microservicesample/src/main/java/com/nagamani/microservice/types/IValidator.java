package com.nagamani.microservice.types;

public interface IValidator<T> {
    void validate(T request);
}
