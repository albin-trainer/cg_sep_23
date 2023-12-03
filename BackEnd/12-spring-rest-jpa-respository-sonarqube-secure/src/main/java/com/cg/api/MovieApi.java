package com.cg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Movie;
import com.cg.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("/movies")
@Tag(name = "Movie", description = "the Movie Api")
@SecurityRequirement(name = "Bearer Authentication")
public class MovieApi {
	@Autowired
	private MovieService movieService;
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping //Shortcut annotation
	public Movie addNewMovie(@RequestBody  @Valid  Movie m) {
		return movieService.addNewMovieService(m);
	}
	@GetMapping
	@Operation(
            summary = "Fetch all Movies",
            description = "fetches all movie entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
	public List<Movie> listOfMovies() {
		return movieService.listOfMoviesService();
	}
	@PutMapping("/{mCode}")
	public Movie UpdateMovie(@RequestBody Movie m, 
			@PathVariable("mCode") int mCode) {
		for(int i=1;i<=10;i++) {
			System.out.println("CG");
		}
		return movieService.updateMovieService(mCode, m);
	}
	@GetMapping("/{movCode}")
	public Movie findByCode(@PathVariable("movCode") int mCode) {
		for(int i=1;i<=10;i++) {
			System.out.println("CG");
		}
		return movieService.findbyMovieCodeService(mCode);
	}
	
	@GetMapping("/genre/{genre}")
	public List<Movie> searchByGenre(@PathVariable String genre) {
		return movieService.searchByGenreService(genre);
	}

	@GetMapping("/genre/{genre}/lang/{lang}")
	public List<Movie> searchByGenreAndLang(@PathVariable String genre,
			@PathVariable String lang) {
		return null;
	}
	@GetMapping("/search/lang/{lang}")
	public List<Movie> searchByLanguages( @PathVariable("lang") String lang){
		return movieService.searchByLanguagesServices(lang);
	}
	@PutMapping("/edit")//edit?genre=Action&movCode=101
	public int editGenre(@RequestParam("genre") String genre, @RequestParam("movCode")int movieCode) {
		return movieService.editGenreByMovieCode(genre, movieCode);
	}
}
