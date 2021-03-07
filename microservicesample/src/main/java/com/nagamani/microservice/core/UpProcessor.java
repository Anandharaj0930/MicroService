package com.nagamani.microservice.core;

import com.nagamani.microservice.proxy.FeigntClientProxy;
import com.nagamani.microservice.types.IValidator;
import com.nagamani.microservice.types.Payload;
import com.nagamani.microservice.types.core.IUpProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class UpProcessor implements IUpProcessor {

    @Autowired
    private FeigntClientProxy feigntClientProxy;

    @Autowired
    private IValidator upProcessorValidator;

    @Override
    public String concateName(Payload payload) {
        log.debug("UpProcessor");
        StringBuilder response = new StringBuilder();
        upProcessorValidator.validate(payload);
        String welcome = feigntClientProxy.loadHello();
        String name = feigntClientProxy.printName(payload);
        return String.format("%s %s", welcome, name);
    }

}
