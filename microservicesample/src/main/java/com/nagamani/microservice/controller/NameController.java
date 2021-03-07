package com.nagamani.microservice.controller;

import com.nagamani.microservice.types.Payload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("name")
@Slf4j
public class NameController {
    private static final String WELCOME = "hello";

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> printName(@RequestBody Payload payload) {
        log.debug("Inside NameController >> printName :" + payload);
        return ResponseEntity.ok(payload.getName() + " " + payload.getSurName());
    }
}
