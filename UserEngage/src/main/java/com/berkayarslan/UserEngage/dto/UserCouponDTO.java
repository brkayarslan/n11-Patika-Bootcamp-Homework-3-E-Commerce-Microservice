package com.berkayarslan.UserEngage.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public record UserCouponDTO (     Long id,
                                  Long userId,
                                  String name,
                                  LocalDate startDate,
                                  LocalDate endDate,
                                  Double amount){




}
