package com.berkayarslan.UserEngage.repository;

import com.berkayarslan.UserEngage.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReviewRepository extends JpaRepository<UserReview,Long> {

    List<UserReview> findByUserId(Long userId);

    List<UserReview> findByProductId(Long productId);
}
