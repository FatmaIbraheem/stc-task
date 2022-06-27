package com.fi.stc.leavesms.integration;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public interface IntegrationService {


    public default ResponseEntity callApi(RestTemplate restTemplate, String url, Object requestObject, HttpEntity httpEntity, HttpMethod httpMethod, Class returnObjectClass) {
        return restTemplate.exchange(
                url,
                httpMethod,
                httpEntity,
                returnObjectClass
        );
    }    // add more method like validation or filter
}
