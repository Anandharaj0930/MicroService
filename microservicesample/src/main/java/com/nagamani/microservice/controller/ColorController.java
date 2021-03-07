package com.nagamani.microservice.controller;

import com.nagamani.microservice.persistence.Employee;
import com.nagamani.microservice.types.ColorRequest;
import com.nagamani.microservice.types.Response;
import com.nagamani.microservice.types.core.IColorProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("color")
public class ColorController {

    @Autowired
    private IColorProcessor processor;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createColor(@RequestBody ColorRequest request) {
        log.info("ColorController >> createColor >> : " + request);
        return ResponseEntity.ok(processor.createColor(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id) {
        log.info("ColorController >> getEmployee >> : " + id);
        return ResponseEntity.ok(processor.getEmployee(id));
    }
}
