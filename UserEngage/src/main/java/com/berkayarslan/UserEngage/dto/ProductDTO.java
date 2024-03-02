package com.berkayarslan.UserEngage.dto;

import com.berkayarslan.UserEngage.model.Status;

import java.time.LocalDateTime;

public record ProductDTO(Long id,
                         String name,
                         double price,
                         LocalDateTime expirationDate,
                         String description,
                         int categoryId,
                         Status status) {
}
