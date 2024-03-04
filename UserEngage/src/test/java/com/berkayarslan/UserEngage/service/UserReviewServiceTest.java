package com.berkayarslan.UserEngage.service;

import com.berkayarslan.UserEngage.exceptions.ItemNotFoundException;
import com.berkayarslan.UserEngage.model.UserReview;
import com.berkayarslan.UserEngage.repository.UserReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserReviewServiceTest {

    @Mock
    private UserReviewRepository userReviewRepository;

    @InjectMocks
    UserReviewService userReviewService;


    @Test
    void findReviewByUserId_withExistingReviews() {
        Long userId = 1L;
        UserReview userReview1 = new UserReview();
        userReview1.setUserId(1L);
        UserReview userReview2 = new UserReview();
        userReview2.setUserId(1L);

        List<UserReview> expectedReviews  = new ArrayList<>();
        expectedReviews .add(userReview1);
        expectedReviews .add(userReview2);

        when(userReviewRepository.findByUserId(userId)).thenReturn(expectedReviews );

        List<UserReview> actualReviews = userReviewService.findReviewByUserId(userId);

        assertFalse(actualReviews.isEmpty());
        assertEquals(expectedReviews,actualReviews);
    }

    @Test
    void findReviewByUserId_withNoReviews(){
        Long userId = 1L;

        when(userReviewRepository.findByUserId(userId)).thenReturn(new ArrayList<>());

        assertThrows(ItemNotFoundException.class, () -> userReviewService.findReviewByUserId(userId));
    }

    @Test
    void findReviewByProductId() {
        UserReview review = new UserReview(); // Populate the review object as needed
        when(userReviewRepository.findByProductId(anyLong())).thenReturn(List.of(review));

        List<UserReview> result = userReviewService.findReviewByProductId(1L);
        assertFalse(result.isEmpty());
        verify(userReviewRepository).findByProductId(1L);
    }

    @Test
    void editComment() {
        UserReview review = new UserReview();
        review.setComment("Old Comment");
        when(userReviewRepository.findById(anyLong())).thenReturn(Optional.of(review));
        when(userReviewRepository.save(any(UserReview.class))).thenAnswer(invocation -> invocation.getArgument(0));

        UserReview updatedReview = userReviewService.editComment(1L, "New Comment");
        assertEquals("New Comment", updatedReview.getComment());
        verify(userReviewRepository).save(review);
    }
}