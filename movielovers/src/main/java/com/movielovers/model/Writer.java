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
import com.movielovers.model.pk.WriterPK;

@Entity(name = "writer")
public class Writer implements Serializable {

	private static final long serialVersionUID = 1L;

	public Writer(String name) {
		this.writerPK = new WriterPK(name, new Date());
	}
	
	public Writer() {}

	@EmbeddedId
	@Column(unique = true, nullable = false)
	private WriterPK writerPK;

	@Column(length = 150)
	private String nationality;

	@ManyToMany(mappedBy = "writers")
	@JsonIgnore
	private Set<Movie> movies = new HashSet<>();

	public String getNationality() {
		return nationality;
	}

	public Set<Movie> getMovies() {
		return movies;
	}
	
	public WriterPK getWriterPK() {
		return writerPK;
	}

	public void setWriterPK(WriterPK writerPK) {
		this.writerPK = writerPK;
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
		movie.getWriters().add(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((writerPK == null) ? 0 : writerPK.hashCode());
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
		Writer other = (Writer) obj;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (writerPK == null) {
			if (other.writerPK != null)
				return false;
		} else if (!writerPK.equals(other.writerPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
