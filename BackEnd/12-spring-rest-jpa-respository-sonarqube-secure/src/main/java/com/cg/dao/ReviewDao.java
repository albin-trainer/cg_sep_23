package com.cg.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Review;
@Repository
public interface ReviewDao  extends JpaRepository<Review, Integer>{
	@Query(value = "select * from Review where movie_code= :movCode",
			nativeQuery = true)
	List<Review> getAllReviews( @Param("movCode") int movCode);
}
