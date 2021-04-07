package br.com.dev2me;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dev2me.entity.Movie;
import br.com.dev2me.repository.MovieRepository;

@SpringBootTest
class Dev2mesbApplicationTests {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	void createTest() {
		String name = "Matrix";
		
		Movie m = new Movie();
		m.setMovieName(name);
		Movie movieSaved = movieRepository.save(m);
		
		assertEquals(movieSaved.getMovieName(), name);
	}
	
	@Test
	void getAllTest() {
		List<Movie> list = movieRepository.findAll();
		
		assertNotNull(list);
	}

}
