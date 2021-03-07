package com.nagamani.microservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@Slf4j
public class HelloController {

    @GetMapping
    public ResponseEntity<String> loadHello() {
        log.debug("HelloController >> loadHello ");
        return ResponseEntity.ok(" Hello");
    }
}
