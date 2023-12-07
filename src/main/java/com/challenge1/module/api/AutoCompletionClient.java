package com.challenge1.module.api;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.challenge1.module.configuration.FeignLoggerConfig;
import com.challenge1.module.exception.BadRequestException;
import com.challenge1.module.exception.InternalServerException;
import com.challenge1.module.exception.UnauthorizedException;
import com.challenge1.module.model.AutoCompletionResponseDTO;
import com.challenge1.module.model.AutocompletionRequestDTO;
import com.challenge1.module.utils.ConstantsUtils;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.Data;

@FeignClient(name = "AutoCompletionClient", url = "${api.baseUrl}", configuration = { FeignLoggerConfig.class, AutoCompletionClientConfig.class })
public interface AutoCompletionClient {

    @PostMapping(value = "${api.autocompletion.path}",
        consumes = MediaType.APPLICATION_JSON_VALUE)
    AutoCompletionResponseDTO getAutocompletion(@RequestHeader(ConstantsUtils.AUTHORIZATION_HEADER) String key,
        @RequestBody AutocompletionRequestDTO request,
        @RequestParam @JsonAlias("case") String caseSensitive,
        @RequestParam String validAddresses);

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    class AutoCompletionErrorResponse {

        private String code;
        private String message;
        @JsonAlias("status_code")
        private String statusCode;

    }

    class CustomErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            AutoCompletionClient.AutoCompletionErrorResponse autoCompletionErrorResponse;
            try {
                InputStream body = response.body().asInputStream();
                ObjectMapper mapper = new ObjectMapper();
                autoCompletionErrorResponse = mapper.readValue(body, AutoCompletionErrorResponse.class);
            } catch (IOException e) {
                throw new InternalServerException("exception happened when calling Order Cards API.", e);
            }
            switch (response.status()) {
                case 400:
                    return new BadRequestException("Bad request", autoCompletionErrorResponse.getMessage());
                case 401:
                    return new UnauthorizedException("Check your credentials", autoCompletionErrorResponse.getMessage());
                default:
                    return new InternalServerException("Failed", autoCompletionErrorResponse.getMessage(), null);
            }
        }
    }
}
