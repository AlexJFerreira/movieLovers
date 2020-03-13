package com.movielovers.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;

//@Entity(name = "wanted_user_movie")
public class WantedUserMovie /*implements Serializable*/ {

	private static final long serialVersionUID = 1L;
    
//	@ManyToOne
//    @JoinColumn(name="original_title")
//    @JoinColumn(name="premiere_year")
    private Movie movie;

//	@ManyToOne
//	@JoinColumn(name = "user_id") 
	private User user; 

	public Movie getMovie() {
		return movie;
	}

	public User getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		WantedUserMovie other = (WantedUserMovie) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
