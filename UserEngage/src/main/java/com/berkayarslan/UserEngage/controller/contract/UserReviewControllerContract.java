package com.berkayarslan.UserEngage.controller.contract;

import com.berkayarslan.UserEngage.dto.UserReviewDTO;
import com.berkayarslan.UserEngage.request.user_review.UserReviewSaveRequest;
import com.berkayarslan.UserEngage.request.user_review.UserReviewUpdateRequest;

import java.util.List;

public interface UserReviewControllerContract {
    UserReviewDTO saveUserReview(UserReviewSaveRequest request);
    List<UserReviewDTO> findReviewListByUserId(Long userId);
    List<UserReviewDTO> findReviewListByProductId(Long productId);
    UserReviewDTO findReviewById(Long id);
    UserReviewDTO editComment(UserReviewUpdateRequest request);
}
