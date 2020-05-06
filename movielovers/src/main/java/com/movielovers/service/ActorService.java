package com.movielovers.service;

import java.time.LocalDate;

import com.movielovers.model.Actor;

public interface ActorService {

	public void persistNewActor(Actor actor);

	Actor findActorByNameAndBornDate(String name, LocalDate bornDate);

}
