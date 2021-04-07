package br.com.dev2me.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev2me.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
