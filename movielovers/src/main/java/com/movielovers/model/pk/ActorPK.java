package com.movielovers.model.pk;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Embeddable
public final class ActorPK implements Serializable {

	public ActorPK(String name, Date bornDate) {
		this.name = name;
		this.bornDate = bornDate;
	}
	
	public ActorPK() {}

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 150)
	private String name;

	@Column(name = "born_date", nullable = false)
	private Date bornDate;


	public String getName() {
		return name;
	}

	public Date getBornDate() {
		return bornDate;
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
		ActorPK other = (ActorPK) obj;
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
