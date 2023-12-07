package com.challenge1.module.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignLoggerConfig {

    @Value("${feign.logging.level}")
    private String loggerLevel;

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.valueOf(loggerLevel.toUpperCase());
    }
}

