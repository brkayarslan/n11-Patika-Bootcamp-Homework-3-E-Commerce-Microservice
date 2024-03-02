package com.berkayarslan.UserEngage.controller.contract.ımpl;

import com.berkayarslan.UserEngage.controller.contract.UserReviewControllerContract;
import com.berkayarslan.UserEngage.dto.UserReviewDTO;
import com.berkayarslan.UserEngage.mapper.UserReviewMapper;
import com.berkayarslan.UserEngage.model.UserReview;
import com.berkayarslan.UserEngage.request.user_review.UserReviewSaveRequest;
import com.berkayarslan.UserEngage.request.user_review.UserReviewUpdateRequest;
import com.berkayarslan.UserEngage.service.UserReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserReviewControllerContractImpl implements UserReviewControllerContract {

    private final UserReviewService reviewService;


    @Override
    public UserReviewDTO saveUserReview(UserReviewSaveRequest request) {
        UserReview review = UserReviewMapper.INSTANCE.convertToUserReview(request);
        review = reviewService.save(review);
        return UserReviewMapper.INSTANCE.userReviewToUserReviewDTO(review);
    }

    @Override
    public List<UserReviewDTO> findReviewListByUserId(Long userId) {
        List<UserReview> reviewList = reviewService.findReviewByUserId(userId);
        return UserReviewMapper.INSTANCE.converToReviewList(reviewList);
    }

    @Override
    public List<UserReviewDTO> findReviewListByProductId(Long productId) {
        List<UserReview> reviewList = reviewService.findReviewByProductId(productId);
        return UserReviewMapper.INSTANCE.converToReviewList(reviewList);
    }

    @Override
    public UserReviewDTO findReviewById(Long id) {
        UserReview review = reviewService.findByIdWithControl(id);
        return UserReviewMapper.INSTANCE.userReviewToUserReviewDTO(review);
    }

    @Override
    public UserReviewDTO editComment(UserReviewUpdateRequest request) {
        return UserReviewMapper.INSTANCE.userReviewToUserReviewDTO(reviewService.editComment(request.id(),request.comment()));
    }
}
