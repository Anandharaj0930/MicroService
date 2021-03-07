package com.nagamani.microservice.common;

import java.util.Optional;

public class StringUtil {
    private static boolean isNotEmpty(String value) {
        return Optional.ofNullable(value)
                .map(String::trim)
                .map(v -> !value.isEmpty())
                .orElse(false);
    }

    private static boolean isEmpty(String value) {
        return Optional.ofNullable(value)
                .map(String::trim)
                .map(v -> value.isEmpty())
                .orElse(true);
    }


}
