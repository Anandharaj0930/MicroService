package com.nagamani.microservice.core;

import com.nagamani.microservice.exception.MicroCoreException;
import com.nagamani.microservice.exception.MicroPersistenceException;
import com.nagamani.microservice.persistence.Employee;
import com.nagamani.microservice.persistence.EmployeeDAO;
import com.nagamani.microservice.types.ColorRequest;
import com.nagamani.microservice.types.Response;
import com.nagamani.microservice.types.core.IColorProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorProcessor implements IColorProcessor {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public Response createColor(ColorRequest request) {
        Response response = null;
        Employee entity = buildEntity(request);
        try {
            entity = employeeDAO.save(entity);
            response = Response.builder().colorId(entity.getId()).description("Successfully persisted").build();
        } catch (DataAccessException exception) {
            throw new MicroPersistenceException();
        }
        return response;
    }

    @Override
    public Employee getEmployee(String id) {
        Optional.ofNullable(id).orElseThrow(MicroCoreException::new);
        Employee employee = employeeDAO.findById(Long.valueOf(id)).orElseThrow(MicroPersistenceException::new);
        return employee;
    }

    private Employee buildEntity(ColorRequest request) {
        return Employee.builder().color(request.getColor()).name(request.getName()).parentId(request.getParentId()).build();
    }
}
