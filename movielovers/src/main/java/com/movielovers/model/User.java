package com.movielovers.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false, precision = 10)
	private int userId;

	@Column(length = 150)
	private String name;

	@Column(name = "user_name", length = 25)
	private String userName;

	@Column(length = 250)
	private String password;

	@Column(name = "born_date")
	private Date bornDate;

	@Column(length = 15)
	private String ip;

	@Column(length = 255)
	private String email;

	@Column(precision = 10)
	private int score;

	@OneToMany(mappedBy = "user")
	private Set<UserBadge> userBadge;

	@OneToMany(mappedBy = "user")
	private Set<UserList> userList;

	//@OneToMany(mappedBy = "user")
	//private Set<WantedUserMovie> wantedUserMovie;

	//@OneToMany(mappedBy = "user")
	//private Set<WatchedUserMovie> watchedUserMovie;

	public int getUserId() {
		return userId; 
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public String getIp() {
		return ip;
	}

	public String getEmail() {
		return email;
	}

	public int getScore() {
		return score;
	}

	public Set<UserBadge> getUserBadge() {
		return userBadge;
	}

	public Set<UserList> getUserList() {
		return userList;
	}

//	public Set<WantedUserMovie> getWantedUserMovie() {
//		return wantedUserMovie;
//	}
//
//	public Set<WatchedUserMovie> getWatchedUserMovie() {
//		return watchedUserMovie;
//	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((bornDate == null) ? 0 : bornDate.hashCode());
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + score;
//		result = prime * result + ((userBadge == null) ? 0 : userBadge.hashCode());
//		result = prime * result + userId;
//		result = prime * result + ((userList == null) ? 0 : userList.hashCode());
//		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
//		result = prime * result + ((wantedUserMovie == null) ? 0 : wantedUserMovie.hashCode());
//		result = prime * result + ((watchedUserMovie == null) ? 0 : watchedUserMovie.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		if (bornDate == null) {
//			if (other.bornDate != null)
//				return false;
//		} else if (!bornDate.equals(other.bornDate))
//			return false;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (ip == null) {
//			if (other.ip != null)
//				return false;
//		} else if (!ip.equals(other.ip))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (password == null) {
//			if (other.password != null)
//				return false;
//		} else if (!password.equals(other.password))
//			return false;
//		if (score != other.score)
//			return false;
//		if (userBadge == null) {
//			if (other.userBadge != null)
//				return false;
//		} else if (!userBadge.equals(other.userBadge))
//			return false;
//		if (userId != other.userId)
//			return false;
//		if (userList == null) {
//			if (other.userList != null)
//				return false;
//		} else if (!userList.equals(other.userList))
//			return false;
//		if (userName == null) {
//			if (other.userName != null)
//				return false;
//		} else if (!userName.equals(other.userName))
//			return false;
//		if (wantedUserMovie == null) {
//			if (other.wantedUserMovie != null)
//				return false;
//		} else if (!wantedUserMovie.equals(other.wantedUserMovie))
//			return false;
//		if (watchedUserMovie == null) {
//			if (other.watchedUserMovie != null)
//				return false;
//		} else if (!watchedUserMovie.equals(other.watchedUserMovie))
//			return false;
//		return true;
//	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
