package com.movielovers.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Actor;
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
		return actorRepository.findByName(name);
	}
	
	@Override
	public void persistNewActor(final Actor actor) {
		 actorRepository.save(actor);
	}
	
}
