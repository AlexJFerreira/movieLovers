package com.movielovers.service;

import java.util.List;

import com.movielovers.domains.MovieVO;
import com.movielovers.model.Movie;

public interface MovieService {

	public List<MovieVO> getMoviesList();

	public void persistNewMovie(Movie movie);

	Movie findMovieByOriginalTitleAndPremiereYear(String originalTitle, Integer premiereYear);

}
