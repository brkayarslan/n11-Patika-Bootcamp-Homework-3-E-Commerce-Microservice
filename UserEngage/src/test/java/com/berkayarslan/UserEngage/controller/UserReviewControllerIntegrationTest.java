package com.berkayarslan.UserEngage.controller;

import com.berkayarslan.UserEngage.controller.contract.UserReviewControllerContract;
import com.berkayarslan.UserEngage.dto.UserReviewDTO;
import com.berkayarslan.UserEngage.dto.UserReviewDetailDTO;
import com.berkayarslan.UserEngage.model.Rate;
import com.berkayarslan.UserEngage.request.user_review.UserReviewSaveRequest;
import com.berkayarslan.UserEngage.request.user_review.UserReviewUpdateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserReviewController.class)
class UserReviewControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserReviewControllerContract reviewControllerContract;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findAllReviewByUserId() throws Exception {
        Long userId = 1L;
        UserReviewDTO reviewDTO = new UserReviewDTO(1L, userId, 1, 1, "FIVE", "Great product");
        List<UserReviewDTO> reviews = Arrays.asList(reviewDTO);

        when(reviewControllerContract.findReviewListByUserId(userId)).thenReturn(reviews);

        mockMvc.perform(get("/api/v1/reviews/userId/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].userId", is(userId.intValue())))
                .andExpect(jsonPath("$.data[0].comment", is("Great product")));

        verify(reviewControllerContract, times(1)).findReviewListByUserId(userId);
    }

    @Test
    void findAllReviewByProductId() throws Exception {
        Long productId = 1L;
        UserReviewDetailDTO reviewDetailDTO = new UserReviewDetailDTO(1L, 1L, "John Doe", Math.toIntExact(productId), "Product Name", 1L, "Category Name", 1, "FIVE", "Great product");
        List<UserReviewDetailDTO> reviewDetails = Arrays.asList(reviewDetailDTO);

        when(reviewControllerContract.findReviewListByProductId(productId)).thenReturn(reviewDetails);

        mockMvc.perform(get("/api/v1/reviews/productId/{id}", productId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].productId", is(productId.intValue())))
                .andExpect(jsonPath("$.data[0].comment", is("Great product")));

        verify(reviewControllerContract, times(1)).findReviewListByProductId(productId);
    }

    @Test
    void findReviewById() throws Exception {
        Long reviewId = 1L;
        UserReviewDTO reviewDTO = new UserReviewDTO(reviewId, 1L, 1, 1, "FIVE", "Excellent");

        when(reviewControllerContract.findReviewById(reviewId)).thenReturn(reviewDTO);

        mockMvc.perform(get("/api/v1/reviews/{id}", reviewId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id", is(reviewId.intValue())))
                .andExpect(jsonPath("$.data.comment", is("Excellent")));

        verify(reviewControllerContract, times(1)).findReviewById(reviewId);
    }

    @Test
    void saveReview() throws Exception {
        UserReviewSaveRequest saveRequest = new UserReviewSaveRequest(1L, 1, 1, Rate.FIVE, "Excellent");
        UserReviewDTO savedReviewDTO = new UserReviewDTO(1L, 1L, 1, 1, "FIVE", "Excellent");

        when(reviewControllerContract.saveUserReview(saveRequest)).thenReturn(savedReviewDTO);

        mockMvc.perform(post("/api/v1/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saveRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.comment", is("Excellent")));

        verify(reviewControllerContract, times(1)).saveUserReview(saveRequest);
    }

    @Test
    void updateReview() throws Exception {
        Long reviewId = 1L;
        UserReviewUpdateRequest updateRequest = new UserReviewUpdateRequest(reviewId, "Updated Comment");
        UserReviewDTO updatedReviewDTO = new UserReviewDTO(reviewId, 1L, 1, 1, "FIVE", "Updated Comment");

        when(reviewControllerContract.editComment(updateRequest)).thenReturn(updatedReviewDTO);

        mockMvc.perform(patch("/api/v1/reviews/{id}", reviewId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.comment", is("Updated Comment")));

        verify(reviewControllerContract, times(1)).editComment(updateRequest);
    }
}
