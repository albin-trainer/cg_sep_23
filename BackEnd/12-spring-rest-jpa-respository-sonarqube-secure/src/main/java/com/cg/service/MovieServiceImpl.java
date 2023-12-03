package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.MovieDao;
import com.cg.entity.Movie;
import com.cg.exception.ApplicationExeption;
@Component
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao movieDao;
	//@Transactional
	@Override
	public Movie addNewMovieService(Movie m) {
		return  movieDao.save(m);
	}
   //@Transactional
	@Override
	public Movie updateMovieService(int movieCode, Movie m) {
		return null;
	}
	public List<Movie> listOfMoviesService() {		
		List<Movie> movies=movieDao.findAll();
		return movies;
	}

	@Override
	public List<Movie> searchByGenreService(String genre) {
		return movieDao.findByGenre(genre);
	}

	@Override
	public List<Movie> searchByReleaseDateService(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Movie findbyMovieCodeService(int movieCode) {
	//	Movie m=movieDao.findById(movieCode).get();
		Movie m=movieDao.findById(movieCode).
				orElseThrow(()-> 
				new ApplicationExeption("Movie Code "+movieCode+" not exists"));
		return m;
	}
	@Override
	public List<Movie> searchByLanguagesServices(String lang) {
		return movieDao.searchMovieByLanguages(lang);
	}
	@Override
	@Transactional
	public int editGenreByMovieCode(String genre, int movieCode) {
		return movieDao.updateGenre(genre, movieCode);
	}

}
