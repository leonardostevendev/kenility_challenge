package com.challenge1.module.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.challenge1.module.api.AutoCompletionClient;
import com.challenge1.module.model.AutoCompletionResponseDTO;
import com.challenge1.module.model.AutocompletionRequestDTO;

@Service
public class AutocompletionServiceImpl implements AutocompletionService {
    private final AutoCompletionClient client;

    private final String key;

    public AutocompletionServiceImpl(AutoCompletionClient client, @Value("${api.autocompletion.api-key}") String key) {
        this.client = client;
        this.key = key;
    }

    @Override
    public AutoCompletionResponseDTO getAutocompletion(AutocompletionRequestDTO requestDTO, String caseSensitive, String validAddresses) {
        return client.getAutocompletion("Basic " + key, requestDTO, caseSensitive, validAddresses);
    }
}
