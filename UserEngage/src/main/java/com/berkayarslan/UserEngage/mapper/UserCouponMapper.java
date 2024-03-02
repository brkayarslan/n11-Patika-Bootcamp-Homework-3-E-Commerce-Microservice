package com.berkayarslan.UserEngage.mapper;

import com.berkayarslan.UserEngage.dto.UserCouponDTO;
import com.berkayarslan.UserEngage.model.UserCoupon;
import com.berkayarslan.UserEngage.request.user.UserSaveRequest;
import com.berkayarslan.UserEngage.request.user_coupon.UserCouponSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserCouponMapper {

    UserCouponMapper INSTANCE = Mappers.getMapper(UserCouponMapper.class);

    UserCouponDTO userCouponToUserCouponDTO(UserCoupon userCoupon);
    UserCoupon userCouponDTOToUSerCoupon(UserCouponSaveRequest userCouponSaveRequest);

    List<UserCouponDTO> userCouponListToUserCouponDTOList(List<UserCoupon> couponList);
}
