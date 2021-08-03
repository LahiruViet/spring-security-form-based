package com.lahiru.demo.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CorsConfigBean {

    @Autowired
    private Environment environment;


    public List<String> getAllowedOrigins() {
        return Arrays.asList(environment.getProperty("web.cors.allowed-origins").split(","));
    }

    public List<String> getAllowedMethod() {
        return Arrays.asList(environment.getProperty("web.cors.allowed-methods").split(","));
    }

    public List<String> getAllowedHeader() {
        return Arrays.asList("*", "x-csrf-token");
    }

}
