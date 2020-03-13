package com.movielovers.service;

import java.util.Date;

import com.movielovers.model.Actor;

public interface ActorService {

	public void persistNewActor(Actor actor);

	Actor findActorByName(String name, Date bornDate);

}
