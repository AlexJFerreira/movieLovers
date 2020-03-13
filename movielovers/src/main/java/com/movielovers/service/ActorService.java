package com.movielovers.service;

import com.movielovers.model.Actor;

public interface ActorService {

	public Actor findActorByName(String name);

	public void persistNewActor(Actor actor);

}
