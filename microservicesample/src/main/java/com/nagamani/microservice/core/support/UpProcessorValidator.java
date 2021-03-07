package com.nagamani.microservice.core.support;

import com.nagamani.microservice.exception.MicroCoreException;
import com.nagamani.microservice.types.IValidator;
import com.nagamani.microservice.types.Payload;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpProcessorValidator implements IValidator<Payload> {

    @Override
    public void validate(Payload request) {
        Optional.ofNullable(request.getName()).orElseThrow(MicroCoreException::new);
        Optional.ofNullable(request.getSurName()).orElseThrow(MicroCoreException::new);
    }

}
