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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	private static final String OMB_URL = "http://www.omdbapi.com/?apikey=8dbada7c&t=%s&y=%s";
	
	@Inject
	public OmdbConsumerController(final MovieBusinessImpl movieBusiness, final RestTemplate restTemplate) {
		this.movieBusiness = movieBusiness;
		this.restTemplate = restTemplate;
	}
	
	@PostMapping("title/{title}/year/{movieYear}/retryAndInsertMovie")
	public MovieOmdbVO retrymovieInfoAndPersist(@PathVariable final String title, @PathVariable final Integer movieYear) {
	logger.info("Iniciando recuperação e inserção na base do filme {} do ano {}", title, movieYear);
  
	final HttpHeaders headers = getDefaultHeaders();
    final  HttpEntity <String> entity = new HttpEntity<>(headers);
    final String urlToConsult = String.format(OMB_URL, title, movieYear);
    
	logger.info("Iniciando acesso à url {}", urlToConsult);
    final MovieOmdbVO body = restTemplate.exchange(urlToConsult, HttpMethod.GET, entity, MovieOmdbVO.class).getBody();

    movieBusiness.movieRegister(Movie.converteMovieOmdbToMovie(body));
    return body;
	}
	
	   @GetMapping("/getMovie")
	   public MovieOmdbVO getMovie() {
		   logger.info("Iniciando get Movie");
	      final HttpHeaders headers = getDefaultHeaders();
	      final  HttpEntity <String> entity = new HttpEntity<>(headers);
	      
	      MovieOmdbVO body = restTemplate.exchange("http://www.omdbapi.com/?apikey=8dbada7c&t=Eternal+Sunshine+of+the+spotless+mind&y=2004", HttpMethod.GET, entity, MovieOmdbVO.class).getBody();
	      	      
	      movieBusiness.movieRegister(Movie.converteMovieOmdbToMovie(body));
	      
	      return body;
	   
	}

	private HttpHeaders getDefaultHeaders() {
		final HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

}
