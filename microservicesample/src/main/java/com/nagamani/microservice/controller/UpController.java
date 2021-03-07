package com.nagamani.microservice.controller;

import com.nagamani.microservice.types.Payload;
import com.nagamani.microservice.types.core.IUpProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
@Slf4j
public class UpController {

    @Autowired
    private IUpProcessor upProcessor;

    @GetMapping
    public ResponseEntity<String> serviceHealth() {
        log.debug("UpController >> serviceHealth ");
        return ResponseEntity.ok(" Up");
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getName(@RequestBody Payload payload) {
        log.debug("UpController >> getName : payload " + payload);
        return ResponseEntity.ok(upProcessor.concateName(payload));
    }
}
