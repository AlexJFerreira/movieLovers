package com.movielovers.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Embeddable
public final class MoviePK implements Serializable {

	public MoviePK(String originalTitle, Integer premiereYear) {
		this.originalTitle = originalTitle;
		this.premiereYear = premiereYear;
	}
	
	public MoviePK() {}
	
	private static final long serialVersionUID = 1L;

	@Column(name = "original_title", nullable = false, length = 150)
	private String originalTitle;

	@Column(name = "premiere_year", nullable = false)
	private Integer premiereYear; 


	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public Integer getPremiereYear() {
		return premiereYear;
	}

	public void setPremiereYear(Integer premiereYear) {
		this.premiereYear = premiereYear;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((originalTitle == null) ? 0 : originalTitle.hashCode());
		result = prime * result + ((premiereYear == null) ? 0 : premiereYear.hashCode());
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
		MoviePK other = (MoviePK) obj;
		if (originalTitle == null) {
			if (other.originalTitle != null)
				return false;
		} else if (!originalTitle.equals(other.originalTitle))
			return false;
		if (premiereYear == null) {
			if (other.premiereYear != null)
				return false;
		} else if (!premiereYear.equals(other.premiereYear))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}