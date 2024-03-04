package com.berkayarslan.UserEngage.controller.contract.impl;

import com.berkayarslan.UserEngage.client.CategoryClient;
import com.berkayarslan.UserEngage.client.ProductClient;
import com.berkayarslan.UserEngage.controller.contract.UserReviewControllerContract;
import com.berkayarslan.UserEngage.dto.CategoryInfoDTO;
import com.berkayarslan.UserEngage.dto.ProductInfoDTO;
import com.berkayarslan.UserEngage.dto.UserReviewDTO;
import com.berkayarslan.UserEngage.dto.UserReviewDetailDTO;
import com.berkayarslan.UserEngage.general.RestResponse;
import com.berkayarslan.UserEngage.mapper.UserReviewMapper;
import com.berkayarslan.UserEngage.model.User;
import com.berkayarslan.UserEngage.model.UserReview;
import com.berkayarslan.UserEngage.request.user_review.UserReviewSaveRequest;
import com.berkayarslan.UserEngage.request.user_review.UserReviewUpdateRequest;
import com.berkayarslan.UserEngage.service.UserReviewService;
import com.berkayarslan.UserEngage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserReviewControllerContractImpl implements UserReviewControllerContract {

    private final UserReviewService reviewService;
    private final ProductClient productClient;
    private final CategoryClient categoryClient;
    private final UserService userService;
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
    public List<UserReviewDetailDTO> findReviewListByProductId(Long productId) {

        List<UserReview> reviewList = reviewService.findReviewByProductId(productId);

        ResponseEntity<RestResponse<ProductInfoDTO>> productInfoDTO = productClient.getProduct(productId);


        Long categoryId = (long) productInfoDTO.getBody().getData().getCategoryId();
        ResponseEntity<RestResponse<CategoryInfoDTO>> categoryInfoDTO = categoryClient.getCategoryName(categoryId);

        String productName = productInfoDTO.getBody().getData().getName();
        String categoryName = categoryInfoDTO.getBody().getData().getName();

        List<UserReviewDetailDTO> reviewDetailDTOS = reviewList.stream()
                .map(review -> {

                    User user = userService.findByIdWithControl(review.getUserId());
                    String fullUserName = user.getName() + " " + user.getSurname();
                    return new UserReviewDetailDTO(
                            review.getId(),
                            review.getUserId(),
                            fullUserName,
                            review.getProductId(),
                            productName,
                            categoryId,
                            categoryName,
                            review.getOrderId(),
                            review.getRate().toString(),
                            review.getComment()
                    );
                }).collect(Collectors.toList());
        return reviewDetailDTOS;
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
