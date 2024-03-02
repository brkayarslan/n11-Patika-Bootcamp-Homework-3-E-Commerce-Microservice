package com.berkayarslan.UserEngage.request.product;

import java.time.LocalDateTime;

public record ProductSaveRequest(String name,
                                 double price,
                                 LocalDateTime expirationDate,
                                 String description,
                                 int categoryId) {
}
