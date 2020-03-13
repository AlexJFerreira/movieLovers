package com.movielovers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Actor;
import com.movielovers.model.pk.ActorPK;

public interface ActorRepository extends JpaRepository<Actor, ActorPK> {
	
	public Actor findByActorPKName(String name);

}
