package com.berkayarslan.UserEngage.dto;



public record UserReviewDetailDTO(Long id,
                                  Long userId,
                                  String userName,
                                  Integer productId,
                                  String productName,
                                  Long categoryId,
                                  String categoryName,
                                  Integer orderId,
                                  String rate,
                                  String comment) {
}
