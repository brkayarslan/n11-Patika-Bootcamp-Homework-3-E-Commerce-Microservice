package com.berkayarslan.UserEngage.controller.contract;

import com.berkayarslan.UserEngage.dto.UserCouponDTO;
import com.berkayarslan.UserEngage.request.user_coupon.UserCouponSaveRequest;

import java.util.List;

public interface UserCouponControllerContract {

    List<UserCouponDTO> findAllUserCoupons(Long id);
    UserCouponDTO findUserCouponById(Long id);
    void deleteUserCoupon(Long id);
    UserCouponDTO saveUserCoupon(UserCouponSaveRequest userCouponSaveRequest);

}
