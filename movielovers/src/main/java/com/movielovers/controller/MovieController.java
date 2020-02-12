package com.movielovers.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movielovers.domains.MovieVO;
import com.movielovers.service.MovieService;

@RestController
public class MovieController {

	private final MovieService movieService;

	@Inject
	public MovieController(final MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/moviesList")
	public List<MovieVO> getMoviesList() {
		return movieService.getMoviesList();
	}

}
