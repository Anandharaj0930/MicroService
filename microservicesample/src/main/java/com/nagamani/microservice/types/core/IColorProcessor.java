package com.nagamani.microservice.types.core;

import com.nagamani.microservice.persistence.Employee;
import com.nagamani.microservice.types.ColorRequest;
import com.nagamani.microservice.types.Response;

public interface IColorProcessor {
    Response createColor(ColorRequest request);

    Employee getEmployee(String id);
}
