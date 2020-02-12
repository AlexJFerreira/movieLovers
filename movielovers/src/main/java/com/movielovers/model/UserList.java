package com.movielovers.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "user_list")
public class UserList implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "list_id", unique = true, nullable = false, precision = 10)
	private int listId;
	
	@Column(length = 150)
	private String title;
	
	@Column(length = 16777215)
	private String description;
	
	@Column(precision = 10)
	private int upvotes;
	
	@OneToMany(mappedBy = "userList")
	private Set<ListMovie> listMovie;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getListId() {
		return listId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getUpvotes() {
		return upvotes;
	}

	public Set<ListMovie> getListMovie() {
		return listMovie;
	}

	public User getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + listId;
		result = prime * result + ((listMovie == null) ? 0 : listMovie.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + upvotes;
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
		UserList other = (UserList) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (listId != other.listId)
			return false;
		if (listMovie == null) {
			if (other.listMovie != null)
				return false;
		} else if (!listMovie.equals(other.listMovie))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (upvotes != other.upvotes)
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
