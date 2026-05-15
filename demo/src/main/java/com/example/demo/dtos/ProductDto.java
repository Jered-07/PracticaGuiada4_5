package com.example.demo.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(String name, String description, BigDecimal price, UUID resource_id) {
    
}
