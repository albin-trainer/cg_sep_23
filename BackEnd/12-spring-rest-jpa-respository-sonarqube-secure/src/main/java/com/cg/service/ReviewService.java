package com.cg.service;

import java.util.List;


import com.cg.entity.Review;

public interface ReviewService {
	 Review addReviewService(Review review,int mCode);
	 List<Review> allReviewsService(int mCode) ;
	public Review updateReview( Review review,int mCode, int revId);
	public Review findReviewById(int mCode, int revId);
}
