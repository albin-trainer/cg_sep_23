package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.MovieDao;
import com.cg.dao.ReviewDao;
import com.cg.entity.Movie;
import com.cg.entity.Review;
import com.cg.exception.ApplicationExeption;
@Component
public class ReviewServiceImpl implements ReviewService{
	@Autowired
private ReviewDao reviewDao;
	@Autowired
	private MovieDao movieDao;
	@Override
	@Transactional
	public Review addReviewService(Review review, int mCode) {
		Movie m=movieDao.findById(mCode).orElseThrow(()->new ApplicationExeption(mCode+" not found"));
		review.setMovie(m);
		reviewDao.save(review);
		return review;
	}

	@Override
	public List<Review> allReviewsService(int mCode) {
		// TODO Auto-generated method stub
		return reviewDao.getAllReviews(mCode);
	}

	@Override
	public Review updateReview(Review review, int mCode, int revId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review findReviewById(int mCode, int revId) {
		// TODO Auto-generated method stub
		return null;
	}

}
