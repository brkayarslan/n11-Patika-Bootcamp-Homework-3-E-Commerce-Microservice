package com.berkayarslan.UserEngage.controller.contract.impl;

import com.berkayarslan.UserEngage.client.CategoryClient;
import com.berkayarslan.UserEngage.client.ProductClient;
import com.berkayarslan.UserEngage.dto.*;
import com.berkayarslan.UserEngage.general.RestResponse;
import com.berkayarslan.UserEngage.mapper.UserReviewMapper;
import com.berkayarslan.UserEngage.model.*;
import com.berkayarslan.UserEngage.request.user_review.UserReviewSaveRequest;
import com.berkayarslan.UserEngage.request.user_review.UserReviewUpdateRequest;
import com.berkayarslan.UserEngage.service.UserReviewService;
import com.berkayarslan.UserEngage.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class UserReviewControllerContractImplTest {

    @Mock
    private UserReviewService reviewService;
    @Mock
    private ProductClient productClient;
    @Mock
    private CategoryClient categoryClient;
    @Mock
    private UserService userService;

    @Mock
    private UserReviewMapper userReviewMapper;

    @InjectMocks
    private UserReviewControllerContractImpl reviewController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUserReview() {
        UserReviewSaveRequest request = new UserReviewSaveRequest(1L, 1, 1, Rate.FIVE, "Great product");
        UserReview userReview = new UserReview(1L,1L,1,1,Rate.FIVE,"Great product");
        UserReviewDTO expectedDto = new UserReviewDTO(1L,1L,1,1,"FIVE","Great product");

        when(reviewService.save(userReview)).thenReturn(userReview);
        when(userReviewMapper.userReviewToUserReviewDTO(userReview)).thenReturn(expectedDto);

        UserReviewDTO actualDto = reviewController.saveUserReview(request);

        assertEquals(actualDto,expectedDto);
    }

    @Test
    void findReviewListByUserId() {
        Long userId = 1L;
        UserReview userReview = new UserReview();
        List<UserReview> reviews = Arrays.asList(userReview);
        UserReviewDTO expectedDto = new UserReviewDTO(1L, userId, 1, 1, "FIVE", "Great product");

        when(reviewService.findReviewByUserId(userId)).thenReturn(reviews);
        when(userReviewMapper.converToReviewList(reviews)).thenReturn(Arrays.asList(expectedDto));

        List<UserReviewDTO> reviewListByUserId = reviewController.findReviewListByUserId(userId);

//        assertEquals(reviewListByUserId,);
    }

    @Test
    void findReviewListByProductId() {
        Long productId = 1L;
        UserReview userReview = new UserReview();
        List<UserReview> reviews = Arrays.asList(userReview);
        ProductInfoDTO productInfoDTO = new ProductInfoDTO(productId, "Product Name", 100.0, null, "Description", 1, null);
        CategoryInfoDTO categoryInfoDTO = new CategoryInfoDTO(1L, "Category Name");
        User user = new User(1L,"Name","Surname", LocalDateTime.now(), LocalDate.now(),"example@email.com", Gender.MALE, Status.ACTIVE); // Assume it's correctly populated with name and surname
        UserReviewDetailDTO expectedDetailDto = new UserReviewDetailDTO(1L, 1L, "User Name", 1, "Product Name", 1L, "Category Name", 1, "FIVE", "Great product");

        when(reviewService.findReviewByProductId(productId)).thenReturn(reviews);
        when(productClient.getProduct(productId)).thenReturn(new ResponseEntity<>(RestResponse.of(productInfoDTO), HttpStatus.OK));
        when(categoryClient.getCategoryName(1L)).thenReturn(new ResponseEntity<>(RestResponse.of(categoryInfoDTO), HttpStatus.OK));
        when(userService.findByIdWithControl(1L)).thenReturn(user);


        reviewController.findReviewListByProductId(productId);

        verify(reviewService, times(1)).findReviewByProductId(productId);

    }

    @Test
    void findReviewById() {
        Long reviewId = 1L;
        UserReview userReview = new UserReview();
        UserReviewDTO expectedDto = new UserReviewDTO(reviewId, 1L, 1, 1, "FIVE", "Great product");

        when(reviewService.findByIdWithControl(reviewId)).thenReturn(userReview);
        when(userReviewMapper.userReviewToUserReviewDTO(userReview)).thenReturn(expectedDto);

        reviewController.findReviewById(reviewId);

        verify(reviewService, times(1)).findByIdWithControl(reviewId);
    }

    @Test
    void editComment() {
        UserReviewUpdateRequest request = new UserReviewUpdateRequest(1L, "Updated comment");
        UserReview userReview = new UserReview();
        UserReviewDTO expectedDto = new UserReviewDTO(1L, 1L, 1, 1, "FIVE", "Updated comment");

        when(reviewService.editComment(request.id(), request.comment())).thenReturn(userReview);
        when(userReviewMapper.userReviewToUserReviewDTO(userReview)).thenReturn(expectedDto);

        reviewController.editComment(request);

        verify(reviewService, times(1)).editComment(request.id(), request.comment());
    }
}
