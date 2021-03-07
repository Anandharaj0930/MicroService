package com.nagamani.microservice.proxy;

import com.nagamani.microservice.types.Payload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "service-proxy", url = "${hello-uri}")
public interface FeigntClientProxy {
    @GetMapping(value = "hello")
    String loadHello();

    @PostMapping(value = "name")
    String printName(Payload request);
}
