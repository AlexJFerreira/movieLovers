package com.movielovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Movie findWriterByOriginalTitleAndPremiereYear(String originalTitle, Integer premiereYear);

}
