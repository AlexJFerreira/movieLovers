package com.movielovers.service;

import java.time.LocalDate;

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
	public Actor findActorByNameAndBornDate(final String name, final LocalDate bornDate) {
		return actorRepository.findActorByNameAndBornDate(name, bornDate);
	}
	
	@Override
	public void persistNewActor(final Actor actor) {
		 actorRepository.save(actor);
	}
	
}
