package com.movielovers.business;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Actor;
import com.movielovers.model.Director;
import com.movielovers.model.Movie;
import com.movielovers.model.Writer;
import com.movielovers.model.pk.ActorPK;
import com.movielovers.model.pk.DirectorPK;
import com.movielovers.model.pk.WriterPK;
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
	public MovieBusinessImpl(final MovieService movieService, final ActorService actorService,
			final DirectorService directorService, WriterService writerService) {
		this.movieService = movieService;
		this.actorService = actorService;
		this.directorService = directorService;
		this.writerService = writerService;
	}

	@Override
	public void movieRegister(final Movie movie) {
		final Set<Actor> actors = movie.getActors();
		final Set<Director> directors = movie.getDirectors();
		final Set<Writer> writers = movie.getWriters();

		persistDirectorsIfNotExist(directors);
		persistWritersIfNotExist(writers);
		persistActorsIfNotExist(actors);
		movieService.persistNewMovie(movie);
	}

	private void persistActorsIfNotExist(Set<Actor> actors) {
		for (Actor actor : actors) {
			if (!isActorInDB(actor.getActorPK())) {
				actorService.persistNewActor(actor);
			}
		}
	}

	private void persistDirectorsIfNotExist(Set<Director> directors) {
		for (Director director : directors) {
			if (!isDirectorInDB(director.getDirectorPK())) {
				directorService.persistNewDirector(director);
			}
		}
	}
	
	private void persistWritersIfNotExist(Set<Writer> writers) {
		for (Writer writer : writers) {
			if (!isWriterInDB(writer.getWriterPK())) {
				writerService.persistNewActor(writer);
			}
		}
	}

	private boolean isActorInDB(ActorPK actorPK) {
		return actorService.findActorById(actorPK).isPresent();
	}

	private boolean isDirectorInDB(DirectorPK directorPK) {
		return directorService.findDirectorById(directorPK).isPresent();
	}

	private boolean isWriterInDB(WriterPK writerPK) {
		return writerService.findWriterById(writerPK).isPresent();
	}

}
