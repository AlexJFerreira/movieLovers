package com.movielovers.model;

import static com.movielovers.omdb.utils.OmdbUtils.adjustMovieDurationTime;
import static com.movielovers.omdb.utils.OmdbUtils.extractActors;
import static com.movielovers.omdb.utils.OmdbUtils.extractDirectors;
import static com.movielovers.omdb.utils.OmdbUtils.extractWriters;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.movielovers.model.pk.MoviePK;
import com.movielovers.omdb.domains.MovieOmdbVO;

@Entity(name = "movie")
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	public Movie(MovieOmdbVO movie) {
		this.plot = movie.getPlot();
		this.genre = movie.getGenre();
		this.country = movie.getCountry();
		this.language = movie.getLanguage();
		this.durationMinutes = adjustMovieDurationTime(movie.getRuntime());
		this.moviePK = new MoviePK(movie.getTitle(), Integer.valueOf(movie.getYear()));
		extractActors(movie.getActors()).stream().forEach(this::addActor);
		extractDirectors(movie.getDirector()).stream().forEach(this::addDirector);
		extractWriters(movie.getWriter()).stream().forEach(this::addWriter);
	}

	public Movie() {
	}

	@EmbeddedId
	@Column(unique = true, nullable = false)
	private MoviePK moviePK;

	@Column(name = "translated_title", length = 150)
	private String translatedTitle;

	@Column(length = 16777215)
	private String plot;

	@Column(length = 150)
	private String genre;

	@Column(length = 250)
	private String country;

	@Column(length = 100)
	private String language;

	@Column(precision = 10)
	private int upvotes;

	@Column(name = "duration_minutes", precision = 10)
	private int durationMinutes;

	@ManyToMany
	@JoinTable(name = "actor_movie", joinColumns = {
			@JoinColumn(name = "premiere_year", referencedColumnName = "premiere_year"),
			@JoinColumn(name = "original_title", referencedColumnName = "original_title") }, inverseJoinColumns = {
					@JoinColumn(name = "name", referencedColumnName = "name"),
					@JoinColumn(name = "born_date", referencedColumnName = "born_date") })
	private Set<Actor> actors = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "director_movie", joinColumns = {
			@JoinColumn(name = "premiere_year", referencedColumnName = "premiere_year"),
			@JoinColumn(name = "original_title", referencedColumnName = "original_title") }, inverseJoinColumns = {
					@JoinColumn(name = "name", referencedColumnName = "name"),
					@JoinColumn(name = "born_date", referencedColumnName = "born_date") })
	private Set<Director> directors = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "writer_movie", joinColumns = {
			@JoinColumn(name = "premiere_year", referencedColumnName = "premiere_year"),
			@JoinColumn(name = "original_title", referencedColumnName = "original_title") }, inverseJoinColumns = {
					@JoinColumn(name = "name", referencedColumnName = "name"),
					@JoinColumn(name = "born_date", referencedColumnName = "born_date") })
	private Set<Writer> writers = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
	private Set<ListMovie> listMovie;

//	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
//	private Set<WantedUserMovie> wantedUserMovie;
//
//	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
//	private Set<WatchedUserMovie> watchedUserMovie;

	public String getTranslatedTitle() {
		return translatedTitle;
	}

	public String getPlot() {
		return plot;
	}

	public String getGenre() {
		return genre;
	}

	public String getCountry() {
		return country;
	}

	public String getLanguage() {
		return language;
	}

	public int getUpvotes() {
		return upvotes;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public MoviePK getMoviePK() {
		return moviePK;
	}

	public void setMoviePK(MoviePK moviePK) {
		this.moviePK = moviePK;
	}

	public void setTranslatedTitle(String translatedTitle) {
		this.translatedTitle = translatedTitle;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	public void setWriters(Set<Writer> writers) {
		this.writers = writers;
	}

	public void setListMovie(Set<ListMovie> listMovie) {
		this.listMovie = listMovie;
	}

//	public void setWantedUserMovie(Set<WantedUserMovie> wantedUserMovie) {
//		this.wantedUserMovie = wantedUserMovie;
//	}
//
//	public void setWatchedUserMovie(Set<WatchedUserMovie> watchedUserMovie) {
//		this.watchedUserMovie = watchedUserMovie;
//	}

	public Set<Actor> getActors() {
		return actors;
	}

	public Set<Director> getDirectors() {
		return directors;
	}

	public Set<ListMovie> getListMovie() {
		return listMovie;
	}

//	public Set<WantedUserMovie> getWantedUserMovie() {
//		return wantedUserMovie;
//	}
//
//	public Set<WatchedUserMovie> getWatchedUserMovie() {
//		return watchedUserMovie;
//	}

	public Set<Writer> getWriters() {
		return writers;
	}

	public static Movie converteMovieOmdbToMovie(MovieOmdbVO movie) {
		return new Movie(movie);
	}

	public void addActor(Actor actor) {
		actors.add(actor);
		actor.getMovies().add(this);
	}

	public void addDirector(Director director) {
		directors.add(director);
		director.getMovies().add(this);
	}

	public void addWriter(Writer writer) {
		writers.add(writer);
		writer.getMovies().add(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((directors == null) ? 0 : directors.hashCode());
		result = prime * result + durationMinutes;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((listMovie == null) ? 0 : listMovie.hashCode());
		result = prime * result + ((moviePK == null) ? 0 : moviePK.hashCode());
		result = prime * result + ((plot == null) ? 0 : plot.hashCode());
		result = prime * result + ((translatedTitle == null) ? 0 : translatedTitle.hashCode());
		result = prime * result + upvotes;
		result = prime * result + ((writers == null) ? 0 : writers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (directors == null) {
			if (other.directors != null)
				return false;
		} else if (!directors.equals(other.directors))
			return false;
		if (durationMinutes != other.durationMinutes)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (listMovie == null) {
			if (other.listMovie != null)
				return false;
		} else if (!listMovie.equals(other.listMovie))
			return false;
		if (moviePK == null) {
			if (other.moviePK != null)
				return false;
		} else if (!moviePK.equals(other.moviePK))
			return false;
		if (plot == null) {
			if (other.plot != null)
				return false;
		} else if (!plot.equals(other.plot))
			return false;
		if (translatedTitle == null) {
			if (other.translatedTitle != null)
				return false;
		} else if (!translatedTitle.equals(other.translatedTitle))
			return false;
		if (upvotes != other.upvotes)
			return false;
		if (writers == null) {
			if (other.writers != null)
				return false;
		} else if (!writers.equals(other.writers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
