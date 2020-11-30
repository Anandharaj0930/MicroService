package com.customer.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@Component
public class ExternalClient<T> implements IExternalClient<T> {

    @Autowired
    private RestTemplate restTemplate;

    public T getMethod(String uri, T t, Map<String, String> params) {
        HttpEntity<String> entity = new HttpEntity(buildHeadders());
        return restTemplate.getForObject(uri, (Class<T>) t, params);

    }

    public HttpHeaders buildHeadders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML));
        return headers;
    }


}
