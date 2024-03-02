package com.berkayarslan.UserEngage.controller;

import com.berkayarslan.UserEngage.controller.contract.UserReviewControllerContract;
import com.berkayarslan.UserEngage.dto.UserReviewDTO;
import com.berkayarslan.UserEngage.general.RestResponse;
import com.berkayarslan.UserEngage.request.user_review.UserReviewSaveRequest;
import com.berkayarslan.UserEngage.request.user_review.UserReviewUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class UserReviewController {

    private UserReviewControllerContract reviewControllerContract;

    public UserReviewController(UserReviewControllerContract reviewControllerContract) {
        this.reviewControllerContract = reviewControllerContract;
    }

    @GetMapping("/userId/{id}")
    public ResponseEntity<RestResponse<List<UserReviewDTO>>> findAllReviewByUserId(@PathVariable Long id){
        List<UserReviewDTO> reviewDTOs = reviewControllerContract.findReviewListByUserId(id);
        return ResponseEntity.ok(RestResponse.of(reviewDTOs));
    }


    @GetMapping("/productId/{id}")
    public ResponseEntity<RestResponse<List<UserReviewDTO>>> findAllReviewByProductId(@PathVariable Long id){
        List<UserReviewDTO> reviewDTOS = reviewControllerContract.findReviewListByProductId(id);
        return ResponseEntity.ok(RestResponse.of(reviewDTOS));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserReviewDTO>> findReviewById(@PathVariable Long id){
        UserReviewDTO reviewDTO = reviewControllerContract.findReviewById(id);
        return ResponseEntity.ok(RestResponse.of(reviewDTO));
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserReviewDTO>> saveReview(@RequestBody UserReviewSaveRequest request){
       UserReviewDTO reviewDTO = reviewControllerContract.saveUserReview(request);
       return ResponseEntity.ok(RestResponse.of(reviewDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RestResponse<UserReviewDTO>> updateReview(@PathVariable Long id,@RequestBody UserReviewUpdateRequest request){
        UserReviewDTO reviewDTO = reviewControllerContract.editComment(request);
        return ResponseEntity.ok(RestResponse.of(reviewDTO));
    }


}
