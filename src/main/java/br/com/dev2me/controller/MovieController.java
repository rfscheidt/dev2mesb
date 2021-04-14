package br.com.dev2me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev2me.entity.Movie;
import br.com.dev2me.entity.MovieType;
import br.com.dev2me.repository.MovieRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/movies")
	public List<Movie> getAll(@RequestParam("movieType") MovieType movieType) {
		if (movieType == MovieType.ALL)
			return movieRepository.findAll();
		else
			return movieRepository.findByMovieType(movieType);
	}

	@PostMapping("/movies")
	public Movie create(@RequestBody Movie movie) {
		System.out.println("create");
		return movieRepository.save(movie);
	}

	@PutMapping("/movies/{id}")
	public void update(@PathVariable(value = "id") Long movieId, @RequestBody Movie movieDetails) {
		//Movie movie = movieRepository.findById(movieId).get();
		//movie.setMovieName(movieDetails.getMovieName());
		//movie.setTrailer(movieDetails.getTrailer());

		movieRepository.save(movieDetails);
	}

	@GetMapping("/movies/{id}")
	public Movie getById(@PathVariable(value = "id") Long movieId) {
		Movie movie = movieRepository.findById(movieId).get();
		return movie;
	}

	@DeleteMapping("/movies/{id}")
	public void delete(@PathVariable(value = "id") Long movieId) {
		movieRepository.deleteById(movieId);
	}


}
