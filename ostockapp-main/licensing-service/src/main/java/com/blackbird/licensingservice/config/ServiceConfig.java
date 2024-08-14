package com.blackbird.licensingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "example")
public class ServiceConfig {
    private String property;
    public String getProperty() {
        return this.property;
    }
}
