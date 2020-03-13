package com.movielovers.domains;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.movielovers.model.Actor;
import com.movielovers.model.Director;
import com.movielovers.model.Movie;
import com.movielovers.model.Writer;

public class MovieVO implements Serializable {

	private static final long serialVersionUID = 1L;

	public MovieVO(final Movie movie) {
		this.translatedTitle = movie.getTranslatedTitle();
		this.originalTitle = movie.getMoviePK().getOriginalTitle();
		this.plot = movie.getPlot();
		this.genre = movie.getGenre();
		this.country = movie.getCountry();
		this.language = movie.getLanguage();
		this.upvotes = movie.getUpvotes();
		this.premiereYear = movie.getMoviePK().getPremiereYear();
		this.durationMinutes = movie.getDurationMinutes();
		this.actors = movie.getActors();
		this.directors = movie.getDirectors();
		this.writers = movie.getWriters();
	}

	private String translatedTitle;
	private String originalTitle;
	private String plot;
	private String genre;
	private String country;
	private String language;
	private Integer upvotes;
	private Integer premiereYear;
	private Integer durationMinutes;
	private Set<Actor> actors;
	private Set<Director> directors;
	private Set<Writer> writers;

	public String getTranslatedTitle() {
		return translatedTitle;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getPlot() {
		return plot;
	}

	public String getGenre() {
		return genre;
	}

	public String getLanguage() {
		return language;
	}

	public Integer getUpvotes() {
		return upvotes;
	}

	public Integer getPremiereYear() {
		return premiereYear;
	}

	public Integer getDurationMinutes() {
		return durationMinutes;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public Set<Director> getDirectors() {
		return directors;
	}

	public Set<Writer> getWriterMovie() {
		return writers;
	}
	
	public String getCountry() {
		return country;
	}

	public static List<MovieVO> converteToListMovieVO(List<Movie> movies) {
		return movies.stream().map(MovieVO::new).collect(Collectors.toList());
	}


}
