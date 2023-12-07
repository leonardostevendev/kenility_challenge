package com.challenge1.module.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge1.module.model.AutoCompletionResponseDTO;
import com.challenge1.module.model.AutocompletionRequestDTO;
import com.challenge1.module.service.AutocompletionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/autocomplete")
public class AutocompletionController {

    private final AutocompletionService autocompletionService;

    public AutocompletionController(AutocompletionService autocompletionService) {
        this.autocompletionService = autocompletionService;
    }

    @PostMapping
    public ResponseEntity<AutoCompletionResponseDTO> getAutoCompletion(@Valid @RequestBody AutocompletionRequestDTO request,
        @RequestParam(name ="case", required=false)String caseSensitive, @RequestParam(required=false) String validAddresses) {
        return ResponseEntity
            .ok()
            .body(autocompletionService.getAutocompletion(request, caseSensitive, validAddresses));
    }
}
