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

@Entity(name = "actor")
public class Actor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Actor(String name) {
		this.name = name.strip();
		this.bornDate = LocalDate.now(); 
	}
	
	public Actor() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id", unique = true, nullable = false, precision = 10)
	private int actorId;

	@Column(length = 150)
	private String name;

	@Column(length = 150)
	private String nationality;

	@Column(name = "born_date")
	private LocalDate bornDate;

	@ManyToMany(mappedBy="actors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonIgnore
	private Set<Movie> movies = new HashSet<>();

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
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
	
    public void setName(String name) {
		this.name = name;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public void addMovie(Movie movie) {
    	movies.add(movie);
    	movie.getActors().add(this);
    }



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bornDate == null) ? 0 : bornDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (bornDate == null) {
			if (other.bornDate != null)
				return false;
		} else if (!bornDate.equals(other.bornDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
