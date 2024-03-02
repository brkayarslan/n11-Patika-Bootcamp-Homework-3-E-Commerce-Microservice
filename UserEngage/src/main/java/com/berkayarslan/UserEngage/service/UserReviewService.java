package com.berkayarslan.UserEngage.service;

import com.berkayarslan.UserEngage.erroremessage.ReviewErrorMessage;
import com.berkayarslan.UserEngage.exceptions.ItemNotFoundException;
import com.berkayarslan.UserEngage.general.BaseEntityService;
import com.berkayarslan.UserEngage.model.UserReview;
import com.berkayarslan.UserEngage.repository.UserReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewService extends BaseEntityService<UserReview,UserReviewRepository> {
    protected UserReviewService(UserReviewRepository repository) {
        super(repository);
    }

    public List<UserReview> findReviewByUserId(Long userId) {

        List<UserReview> userReviews = getRepository().findByUserId(userId);
        if(userReviews.isEmpty()){
            throw new ItemNotFoundException(ReviewErrorMessage.REVIEW_NOT_FOUND);
        } else {
            return userReviews;
        }
    }

    public List<UserReview> findReviewByProductId(Long productId) {
        return getRepository().findByProductId(productId);
    }

    public UserReview editComment(Long id, String comment){
        UserReview review = super.findByIdWithControl(id);
        review.setComment(comment);
        return save(review);
    }


}
