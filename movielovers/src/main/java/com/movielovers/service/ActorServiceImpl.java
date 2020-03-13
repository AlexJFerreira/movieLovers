package com.movielovers.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Actor;
import com.movielovers.model.pk.ActorPK;
import com.movielovers.repository.ActorRepository;

@Named("actorService")
public class ActorServiceImpl implements ActorService {
	
	private final ActorRepository actorRepository;
	
	@Inject
	public ActorServiceImpl(final ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
	@Override
	public Actor findActorByName(final String name) {
		return actorRepository.findByActorPKName(name);
	}
	
	@Override
	public Optional<Actor> findActorById(final ActorPK actorPK) {
		return actorRepository.findById(actorPK);
	}
	
	@Override
	public void persistNewActor(final Actor actor) {
		 actorRepository.save(actor);
	}
	
}
