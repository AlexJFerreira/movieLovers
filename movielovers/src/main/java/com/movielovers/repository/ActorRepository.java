package com.movielovers.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movielovers.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	
	public Actor findActorByNameAndBornDate(String name, Date bornDate);

}
