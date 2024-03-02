package com.berkayarslan.UserEngage.request.user_review;

import com.berkayarslan.UserEngage.model.Rate;

public record UserReviewSaveRequest(Long userId,
                                    Integer productId,
                                    Integer orderId,
                                    Rate rate,
                                    String comment) {
}
