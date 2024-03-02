package com.berkayarslan.UserEngage.controller;

import com.berkayarslan.UserEngage.controller.contract.UserCouponControllerContract;
import com.berkayarslan.UserEngage.dto.UserCouponDTO;
import com.berkayarslan.UserEngage.general.RestResponse;
import com.berkayarslan.UserEngage.request.user_coupon.UserCouponSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userCoupons")
public class UserCouponController {

    private UserCouponControllerContract couponControllerContract;

    public UserCouponController(UserCouponControllerContract couponControllerContract) {
        this.couponControllerContract = couponControllerContract;
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<RestResponse<List<UserCouponDTO>>> findAllUsersCoupons(@PathVariable Long user_id){
        List<UserCouponDTO> couponDTOList = couponControllerContract.findAllUserCoupons(user_id);
        return ResponseEntity.ok(RestResponse.of(couponDTOList));
    }

    @GetMapping("/{id}/coupon")
    public ResponseEntity<RestResponse<UserCouponDTO>> findUsersCouponById(@PathVariable Long id){
        UserCouponDTO couponDTO = couponControllerContract.findUserCouponById(id);
        return ResponseEntity.ok(RestResponse.of(couponDTO));
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserCouponDTO>> saveUserCoupon(@RequestBody UserCouponSaveRequest request){
        UserCouponDTO couponDTO = couponControllerContract.saveUserCoupon(request);
        return ResponseEntity.ok(RestResponse.of(couponDTO));
    }

    @DeleteMapping("/{id}/coupon")
    public void deleteUserCoupon(@PathVariable Long id){
        couponControllerContract.deleteUserCoupon(id);
    }



}
