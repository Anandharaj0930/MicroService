package com.nagamani.microservice.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payload {
    @JsonProperty(value = "Name")
    private String name;
    @JsonProperty(value = "SurName")
    private String surName;
}
