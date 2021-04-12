package br.com.dev2me.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev2me.entity.Movie;
import br.com.dev2me.entity.MovieType;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	public List<Movie> findByMovieType(MovieType movieType);

}
