package com.berkayarslan.UserEngage.service;

import com.berkayarslan.UserEngage.erroremessage.UserCouponErrorMessage;
import com.berkayarslan.UserEngage.exceptions.ItemNotFoundException;
import com.berkayarslan.UserEngage.general.BaseEntityService;
import com.berkayarslan.UserEngage.model.UserCoupon;
import com.berkayarslan.UserEngage.repository.UserCouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCouponService extends BaseEntityService<UserCoupon, UserCouponRepository> {
    protected UserCouponService(UserCouponRepository repository) {
        super(repository);
    }

    public List<UserCoupon> findByUserId(Long user_id) {
        List<UserCoupon> userCoupons = getRepository().findByUserId(user_id);
        if(userCoupons.isEmpty()){
            throw new ItemNotFoundException(UserCouponErrorMessage.USERS_COUPON_NOT_FOUND);
        }
        else {
            return userCoupons;
        }
    }
}
