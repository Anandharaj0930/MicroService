package com.customer.external;

import java.util.Map;

public interface IExternalClient<T> {
    T getMethod(String uri, T t, Map<String, String> params);
}
