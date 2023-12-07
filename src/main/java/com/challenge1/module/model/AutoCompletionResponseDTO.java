package com.challenge1.module.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoCompletionResponseDTO {
    private String id;
    private List<Suggestion> suggestions;
    private String object;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Suggestion {
        private String primaryLine;
        private String city;
        private String state;
        private String zipCode;
    }
}
