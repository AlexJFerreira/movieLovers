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
import com.movielovers.model.pk.ActorPK;

@Entity(name = "actor")
public class Actor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Actor(String name) {
		this.actorPK = new ActorPK(name, new Date());
	}
	
	public Actor() {}

    @EmbeddedId
    @Column(unique=true, nullable=false)
    private ActorPK actorPK;

	@Column(length = 150)
	private String nationality;

	@ManyToMany(mappedBy="actors")
	@JsonIgnore
	private Set<Movie> movies = new HashSet<>();

	public String getNationality() {
		return nationality;
	}

	public Set<Movie> getMovies() {
		return movies;
	}
	

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	public ActorPK getActorPK() {
		return actorPK;
	}

	public void setActorPK(ActorPK actorPK) {
		this.actorPK = actorPK;
	}

	public void addMovie(Movie movie) {
    	movies.add(movie);
    	movie.getActors().add(this);
    }

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorPK == null) ? 0 : actorPK.hashCode());
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
		Actor other = (Actor) obj;
		if (actorPK == null) {
			if (other.actorPK != null)
				return false;
		} else if (!actorPK.equals(other.actorPK))
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
