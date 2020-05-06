package com.movielovers.business;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Actor;
import com.movielovers.model.Director;
import com.movielovers.model.Movie;
import com.movielovers.model.Writer;
import com.movielovers.service.ActorService;
import com.movielovers.service.DirectorService;
import com.movielovers.service.MovieService;
import com.movielovers.service.WriterService;

@Named("movieBusiness")
public class MovieBusinessImpl implements MovieBusiness {
	
	private final MovieService movieService;	
	private final ActorService actorService;
	private final DirectorService directorService;
	private final WriterService writerService;

	
	@Inject
	public MovieBusinessImpl(final MovieService movieService, final ActorService actorService, final DirectorService directorService, final WriterService writerService) {
		this.movieService = movieService;
		this.actorService = actorService;
		this.directorService = directorService;
		this.writerService = writerService;
	}
	
	@Override
	public void movieRegister(Movie movie) {
		if(movieService.findMovieByOriginalTitleAndPremiereYear(movie.getOriginalTitle(), movie.getPremiereYear()) == null) {
			preProcessMovieProperties(movie);
			movieService.persistNewMovie(movie);					
		}
	}

	private void preProcessMovieProperties(Movie movie) {
		Set<Actor> actors = movie.getActors();
		Set<Director> directors = movie.getDirectors();
		Set<Writer> writers = movie.getWriters();
		

		final Set<Actor> actorCopy = new HashSet<>(actors);
		for (Actor actor : actors) {
			Actor actorFromDb = actorService.findActorByNameAndBornDate(actor.getName(), actor.getBornDate());
			if(actorFromDb != null) {
				actorCopy.remove(actor);
				actorCopy.add(actorFromDb);
		}
		}
		
		final Set<Director> directorCopy = new HashSet<>(directors);
		for (Director director : directors) {
			Director directorFromDb = directorService.findDirectorByNameAndBornDate(director.getName(), director.getBornDate());
			if(directorFromDb != null) {
				directorCopy.remove(director);
				directorCopy.add(directorFromDb);
		}
		}
		
		final Set<Writer> writerCopy = new HashSet<>(writers);
		for (Writer writer : writers) {
			Writer writerFromDb = writerService.findWriterByNameAndBornDate(writer.getName(), writer.getBornDate());
			if(writerFromDb != null) {
				writerCopy.remove(writer);
				writerCopy.add(writerFromDb);
		}
		}
		
		

		movie.setActors(actorCopy);
		movie.setDirectors(directorCopy);
		movie.setWriters(writerCopy);
	}

//	private Set<Actor> cleanFromListAlreadyInDBActors(Set<Actor> actors) {
//		return actors.stream().filter(a -> !isActorInDB(a.getName(), a.getBornDate())).collect(Collectors.toSet());
//	}
//	
//	private boolean isActorInDB(String name, LocalDate bornDate) {
//		return actorService.findActorByName(name, bornDate) != null;
//	}

}
