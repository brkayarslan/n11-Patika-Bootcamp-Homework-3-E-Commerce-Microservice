package com.berkayarslan.UserEngage.controller.contract.ımpl;

import com.berkayarslan.UserEngage.dto.UserCouponDTO;
import com.berkayarslan.UserEngage.mapper.UserCouponMapper;
import com.berkayarslan.UserEngage.model.UserCoupon;
import com.berkayarslan.UserEngage.request.user_coupon.UserCouponSaveRequest;
import com.berkayarslan.UserEngage.service.UserCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserCouponControllerContractImpl implements com.berkayarslan.UserEngage.controller.contract.UserCouponControllerContract {

    private final UserCouponService couponService;

    @Override
    public List<UserCouponDTO> findAllUserCoupons(Long user_id) {
        List<UserCoupon> couponList = couponService.findByUserId(user_id);
        return UserCouponMapper.INSTANCE.userCouponListToUserCouponDTOList(couponList);
    }

    @Override
    public UserCouponDTO findUserCouponById(Long id) {
        UserCoupon coupon = couponService.findByIdWithControl(id);
        return UserCouponMapper.INSTANCE.userCouponToUserCouponDTO(coupon);
    }

    @Override
    public void deleteUserCoupon(Long id) {
        couponService.delete(id);
    }

    @Override
    public UserCouponDTO saveUserCoupon(UserCouponSaveRequest userCouponSaveRequest) {
        UserCoupon coupon = UserCouponMapper.INSTANCE.userCouponDTOToUSerCoupon(userCouponSaveRequest);
        coupon = couponService.save(coupon);
        return UserCouponMapper.INSTANCE.userCouponToUserCouponDTO(coupon);
    }
}
