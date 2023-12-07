package com.challenge1.module.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutocompletionRequestDTO {
    @JsonAlias("address_prefix")
    private String addressPrefix;
    private String city;
    private String state;
    private String zip_code;
    @JsonAlias("geo_ip_sort")
    private String geoIpSort;
}
