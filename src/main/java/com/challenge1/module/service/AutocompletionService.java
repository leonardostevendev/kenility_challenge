package com.challenge1.module.service;

import com.challenge1.module.model.AutoCompletionResponseDTO;
import com.challenge1.module.model.AutocompletionRequestDTO;

public interface AutocompletionService {
    AutoCompletionResponseDTO getAutocompletion(AutocompletionRequestDTO requestDTO, String caseSensitive, String validAddresses);
}
