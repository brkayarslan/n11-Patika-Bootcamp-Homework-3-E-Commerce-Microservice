package com.berkayarslan.UserEngage.request.user_coupon;

import java.time.LocalDate;

public record UserCouponSaveRequest(Long userId,
                                    String name,
                                    LocalDate startDate,
                                    LocalDate endDate,
                                    Double amount) {
}
