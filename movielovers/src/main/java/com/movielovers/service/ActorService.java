package com.movielovers.service;

import java.util.Optional;

import com.movielovers.model.Actor;
import com.movielovers.model.pk.ActorPK;

public interface ActorService {

	public Actor findActorByName(String name);

	public void persistNewActor(Actor actor);

	public Optional<Actor> findActorById(ActorPK actorPK);

}
