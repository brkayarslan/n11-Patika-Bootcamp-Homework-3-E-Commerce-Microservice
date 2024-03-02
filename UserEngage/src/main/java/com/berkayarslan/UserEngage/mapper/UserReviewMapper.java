package com.berkayarslan.UserEngage.mapper;

import com.berkayarslan.UserEngage.dto.UserReviewDTO;
import com.berkayarslan.UserEngage.model.UserReview;
import com.berkayarslan.UserEngage.request.user_review.UserReviewSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserReviewMapper {

    UserReviewMapper INSTANCE = Mappers.getMapper(UserReviewMapper.class);

    UserReviewDTO userReviewToUserReviewDTO(UserReview userReview);

    UserReview convertToUserReview(UserReviewSaveRequest request);

    List<UserReviewDTO> converToReviewList(List<UserReview> review);
}
