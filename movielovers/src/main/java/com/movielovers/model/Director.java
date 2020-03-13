package com.movielovers.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movielovers.model.pk.DirectorPK;

@Entity(name = "director")
public class Director implements Serializable {

	private static final long serialVersionUID = 1L;

	public Director(String name) {
		this.directorPK = new DirectorPK(name, new Date());
	}

	public Director() {
	}

	@EmbeddedId
	@Column(unique = true, nullable = false)
	private DirectorPK directorPK;

	@Column(length = 150)
	private String nationality;

	@ManyToMany(mappedBy = "directors")
	@JsonIgnore
	private Set<Movie> movies = new HashSet<>();

	public DirectorPK getDirectorPK() {
		return directorPK;
	}

	public void setDirectorPK(DirectorPK directorPK) {
		this.directorPK = directorPK;
	}

	public String getNationality() {
		return nationality;
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
		result = prime * result + ((directorPK == null) ? 0 : directorPK.hashCode());
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
		if (directorPK == null) {
			if (other.directorPK != null)
				return false;
		} else if (!directorPK.equals(other.directorPK))
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
