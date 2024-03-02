package com.berkayarslan.UserEngage.service;

import com.berkayarslan.UserEngage.exceptions.ItemNotFoundException;
import com.berkayarslan.UserEngage.model.UserCoupon;
import com.berkayarslan.UserEngage.repository.UserCouponRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserCouponServiceTest {

    @Mock
    private UserCouponRepository userCouponRepository;

    @InjectMocks
    private UserCouponService userCouponService;

    @Test
    void findByUserId_WithExistingCoupon() {
        Long userId = 1L;
        UserCoupon userCoupon1 = new UserCoupon();
        userCoupon1.setUserId(1L);
        UserCoupon userCoupon2 = new UserCoupon();
        userCoupon2.setUserId(1L);

        List<UserCoupon> expectedCoupons = new ArrayList<>();
        expectedCoupons.add(userCoupon1);
        expectedCoupons.add(userCoupon2);

        when(userCouponRepository.findByUserId(userId)).thenReturn(expectedCoupons);

        List<UserCoupon> actualCoupons = userCouponService.findByUserId(userId);

        assertFalse(actualCoupons.isEmpty());
        assertEquals(expectedCoupons,actualCoupons);
    }

    @Test
    void findByUserId_WithNoCoupon(){

        Long userId = 1L;

        assertThrows(ItemNotFoundException.class, () -> userCouponService.findByUserId(userId));
    }
}