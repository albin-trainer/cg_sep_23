package com.cg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Review;
import com.cg.service.ReviewService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@CrossOrigin
@RestController
@RequestMapping("/movies/{mCode}/reviews")
@SecurityRequirement(name = "Bearer Authentication")
public class ReviewApi {
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
public Review addReview(@RequestBody Review review,
		@PathVariable("mCode") int mCode) {
	return reviewService.addReviewService(review, mCode);
}
	
@GetMapping
public List<Review> allReviews(@PathVariable("mCode") int mCode) {
	System.out.println(mCode);
	 List<Review> reviews=	reviewService.allReviewsService(mCode);
	 System.out.println(reviews);
	return reviews;
}
@PutMapping("/{revId}")
public Review updateReview(@RequestBody Review review,
	@PathVariable("mCode") int mCode,@PathVariable("revId") int revId) {
return null;
}
@GetMapping("/{revId}")
public Review findReviewById(@PathVariable("mCode") int mCode,@PathVariable("revId") int revId) {
return null;
}
}
