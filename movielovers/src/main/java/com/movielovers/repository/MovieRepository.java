package com.movielovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Movie;
import com.movielovers.model.pk.MoviePK;

public interface MovieRepository extends JpaRepository<Movie, MoviePK> {

}
