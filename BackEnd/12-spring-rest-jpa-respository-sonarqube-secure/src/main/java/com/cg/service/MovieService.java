package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.entity.Movie;

public interface MovieService {
	public Movie addNewMovieService(Movie m);
	public Movie updateMovieService(int movieCode, Movie m);
	public List<Movie> listOfMoviesService();
	public List<Movie> searchByGenreService(String genre);
	public List<Movie> searchByReleaseDateService(LocalDate date);
	public Movie findbyMovieCodeService(int movieCode);
	public List<Movie> searchByLanguagesServices(String lang);
	public int editGenreByMovieCode(String genre, int movieCode);

}
