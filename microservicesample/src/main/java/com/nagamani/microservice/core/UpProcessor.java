package com.nagamani.microservice.core;

import com.nagamani.microservice.exception.MicroExternalException;
import com.nagamani.microservice.proxy.FeigntClientProxy;
import com.nagamani.microservice.types.IValidator;
import com.nagamani.microservice.types.Payload;
import com.nagamani.microservice.types.core.IUpProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


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
        upProcessorValidator.validate(payload);
        String response;
        CompletableFuture<String> loadHellow = CompletableFuture.supplyAsync(feigntClientProxy::loadHello);
        CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> feigntClientProxy.printName(payload));

        CompletableFuture<String> responseFuture = loadHellow.thenCombine(nameFuture, (hello, name) -> hello + " " + name);
        try {
            response = responseFuture.get();
        } catch (InterruptedException e) {
            throw new MicroExternalException();
        } catch (ExecutionException e) {
            throw new MicroExternalException();
        }
        /*String welcome = feigntClientProxy.loadHello();
        String name = feigntClientProxy.printName(payload);*/
        return response;

    }
}
