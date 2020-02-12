package com.movielovers.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "director")
public class Director implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Director(String name) {
		this.name = name;
	}
	
	public Director() {}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "director_id", unique = true, nullable = false, precision = 10)
	private int directorId;

	@Column(length = 150)
	private String name;

	@Column(length = 150)
	private String nationality;

	@Column(name = "born_date")
	private LocalDate bornDate;

	@ManyToMany(mappedBy="directors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonIgnore
	private Set<Movie> movies = new HashSet<>();

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public Set<Movie> getMovies() {
		return movies;
	}
	
	public void addMovie(Movie movie) {
    	movies.add(movie);
    	movie.getDirectors().add(this);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bornDate == null) ? 0 : bornDate.hashCode());
		result = prime * result + directorId;
		result = prime * result + ((movies == null) ? 0 : movies.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
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
		Director other = (Director) obj;
		if (bornDate == null) {
			if (other.bornDate != null)
				return false;
		} else if (!bornDate.equals(other.bornDate))
			return false;
		if (directorId != other.directorId)
			return false;
		if (movies == null) {
			if (other.movies != null)
				return false;
		} else if (!movies.equals(other.movies))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
