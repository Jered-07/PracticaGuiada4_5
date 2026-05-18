package com.example.demo.models;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequestModel(
    @NotBlank(message = "Debe tener un nombre") String name,
    String description,
    @NotNull(message = "Debe tener precio") @Positive(message = "El precio debe ser positivo") BigDecimal price) {
}
