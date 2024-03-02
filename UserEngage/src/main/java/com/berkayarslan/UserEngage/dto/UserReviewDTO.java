package com.berkayarslan.UserEngage.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


public record UserReviewDTO (Long id,
        Long userId,
        Integer productId,
        Integer orderId,
        String rate,
        String comment){



}
