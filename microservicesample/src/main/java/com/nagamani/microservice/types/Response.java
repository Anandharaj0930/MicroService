package com.nagamani.microservice.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Long colorId;
    private String description;
}
