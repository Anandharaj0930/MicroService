package com.customer.core;

import com.customer.types.IBuildOrderCode;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BuildOrderCode implements IBuildOrderCode {
    private static final String ord = "ORD";

    @Override
    public String buildOrderCode() {
        StringBuilder stringBuilder = new StringBuilder(ord);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyymmssSSS");
        String dateValue = format.format(date);
        stringBuilder.append(dateValue);
        return stringBuilder.toString();
    }
}
