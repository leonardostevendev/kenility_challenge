package com.challenge1.module.api;

import org.springframework.context.annotation.Bean;

import feign.codec.ErrorDecoder;

public class AutoCompletionClientConfig {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new AutoCompletionClient.CustomErrorDecoder();
    }
}
