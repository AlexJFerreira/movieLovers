package com.movielovers.omdb.controller;

import java.util.Arrays;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movielovers.business.MovieBusinessImpl;
import com.movielovers.model.Movie;
import com.movielovers.omdb.domains.MovieOmdbVO;

@RestController
public class OmdbConsumerController {
	
	private final Logger logger = LoggerFactory.getLogger(OmdbConsumerController.class);
	private final MovieBusinessImpl movieBusiness;
	private final RestTemplate restTemplate;

	@Inject
	public OmdbConsumerController(final MovieBusinessImpl movieBusiness, final RestTemplate restTemplate) {
		this.movieBusiness = movieBusiness;
		this.restTemplate = restTemplate;
	}
	
	   @GetMapping("/getMovie")
	   public MovieOmdbVO getMovie() {
		   logger.info("Iniciando get Movie");
	      final HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      final  HttpEntity <String> entity = new HttpEntity<>(headers);
	      
	      MovieOmdbVO body = restTemplate.exchange("http://www.omdbapi.com/?apikey=8dbada7c&t=Eternal+Sunshine+of+the+spotless+mind&y=2004", HttpMethod.GET, entity, MovieOmdbVO.class).getBody();
	      	      
	      movieBusiness.movieRegister(Movie.converteMovieOmdbToMovie(body));
	      
	      return body;
	   
	}

}
