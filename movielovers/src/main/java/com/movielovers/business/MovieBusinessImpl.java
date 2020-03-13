package com.movielovers.business;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Actor;
import com.movielovers.model.Movie;
import com.movielovers.service.ActorService;
import com.movielovers.service.MovieService;

@Named("movieBusiness")
public class MovieBusinessImpl implements MovieBusiness {
	
	private final MovieService movieService;	
	private final ActorService actorService;
	
	@Inject
	public MovieBusinessImpl(final MovieService movieService, final ActorService actorService) {
		this.movieService = movieService;
		this.actorService = actorService;
	}
	
	@Override
	public void movieRegister(Movie movie) {
		//final Set<Actor> atores = movie.getActors();
		//persistActorsIfNotExist(atores);
	//	movie.getActors().forEach(m -> m.addMovie(movie));
		//movie.getActors().forEach(a -> movie.addActor(actor));
		System.out.println("Filme a ser persistido "+movie);
		movieService.persistNewMovie(movie);
		
		
	}

	private void persistActorsIfNotExist(Set<Actor> actors) {
		for (Actor actor : actors) {
			if(!isActorInDB(actor.getName())) {
				actorService.persistNewActor(actor);
			}
		}
	}
	
	private boolean isActorInDB(String name) {
		return actorService.findActorByName(name) != null;
	}

}
