package com.movielovers.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.movielovers.domains.MovieVO;
import com.movielovers.model.Movie;
import com.movielovers.repository.MovieRepository;

@Named("movieService")
public class MovieServiceImpl implements MovieService {
	
	private final MovieRepository movieRepository;
	
	@Inject
	public MovieServiceImpl(final MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	
	@Override
	public List<MovieVO> getMoviesList() {
		return MovieVO.converteToListMovieVO(movieRepository.findAll());
	}
	
	@Override
	public Movie findMovieByOriginalTitleAndPremiereYear(final String originalTitle, final Integer premiereYear) {
		return movieRepository.findWriterByOriginalTitleAndPremiereYear(originalTitle, premiereYear);
	}
	
	@Transactional
	@Override
	public void persistNewMovie(Movie movie) {
		 movieRepository.save(movie);
	}

}
