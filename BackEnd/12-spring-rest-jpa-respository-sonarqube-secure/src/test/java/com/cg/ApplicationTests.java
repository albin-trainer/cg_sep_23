package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dao.MovieDao;
import com.cg.entity.Movie;
import com.cg.service.MovieService;

@SpringBootTest
class ApplicationTests {
private List<Movie> movies=new ArrayList<>();
@MockBean
private MovieDao movieDao;
@Autowired
private MovieService movieService;
Movie m1= new Movie();

Movie m2= new Movie();


@BeforeEach
void setUp(){
	m1.setMovieCode(1);
	m1.setMovieName("RRR");
	m1.setGenre("Action");
	m1.setLanguage("Telugu");
	m2.setMovieCode(2);
	m2.setMovieName("Leo");
	m2.setGenre("Action");
	m2.setLanguage("Tamil");

	movies.add(m1); movies.add(m2);
}
	@Test
	void testAllMovies() {
		when(movieDao.findAll()).thenReturn(movies);
		List<Movie> mlist=movieService.listOfMoviesService();
		assertEquals(movies.size(), mlist.size());
		System.out.println(movies.size());
		Mockito.verify(movieDao, Mockito.times(1)).findAll();
	}

}
