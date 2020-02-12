package com.movielovers.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "user_badge")
public class UserBadge implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_badge_id", unique=true, nullable=false, precision=10)
    private int userBadgeId;
    
	@ManyToOne
	@JoinColumn(name = "badge_id")
	private Badge badge;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
    public int getUserBadgeId() {
        return userBadgeId;
    }

	public Badge getBadge() {
		return badge;
	}

	public User getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((badge == null) ? 0 : badge.hashCode());
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
		UserBadge other = (UserBadge) obj;
		if (badge == null) {
			if (other.badge != null)
				return false;
		} else if (!badge.equals(other.badge))
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
