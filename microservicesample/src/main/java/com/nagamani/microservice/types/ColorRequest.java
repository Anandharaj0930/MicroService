package com.nagamani.microservice.types;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ColorRequest {
    private String name;
    private String color;
    private String parentId;
}
