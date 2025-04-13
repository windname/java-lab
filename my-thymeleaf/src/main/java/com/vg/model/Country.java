package com.vg.model;

import java.util.Arrays;
import java.util.List;

public class Country {
    private String code;
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters
    public String getCode() { return code; }
    public String getName() { return name; }

    // Static method to get countries
    public static List<Country> getCountries() {
        return Arrays.asList(
                new Country("US", "United States"),
                new Country("CA", "Canada"),
                new Country("UK", "United Kingdom"),
                new Country("DE", "Germany")
        );
    }
}