package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dao.MovieDao;
import com.cg.entity.Movie;
import com.cg.service.MovieService;

@SpringBootTest
public class MovieServiceTest {
  // @InjectMocks
	@MockBean
	private MovieDao movieDao;
	@Autowired
	private MovieService movieService;
	
	private List<Movie> mockMovies=
			new ArrayList<>();
	@BeforeEach
	void preTest() {
		Movie m1=new Movie(1, "RRR", "Telugu", "genre", "Action", LocalDate.now());
		Movie m2=new Movie(2, "Leo", "Tamil", "genre", "Action", LocalDate.now());
		Movie m3=new Movie(3, "Inception", "English", "genre", "SCIFI", LocalDate.now());
		mockMovies.add(m1);
		mockMovies.add(m2);
		mockMovies.add(m3);
	}
	
	@Test
	public void testAllMovies() {
		//pre condtion
		when(movieDao.findAll()).thenReturn(mockMovies);		
	   List<Movie> movies= movieService.listOfMoviesService();
	   assertEquals(movies.size(), mockMovies.size());
	   
	}
	
}
