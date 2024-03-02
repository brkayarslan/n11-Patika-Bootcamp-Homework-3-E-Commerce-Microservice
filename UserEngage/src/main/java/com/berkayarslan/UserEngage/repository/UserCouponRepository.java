package com.berkayarslan.UserEngage.repository;

import com.berkayarslan.UserEngage.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCouponRepository extends JpaRepository<UserCoupon,Long> {

    List<UserCoupon> findByUserId(Long userId);
}
