package com.movielovers.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Director;
import com.movielovers.model.pk.DirectorPK;
import com.movielovers.repository.DirectorRepository;

@Named("directorService")
public class DirectorServiceImpl implements DirectorService {
	
	private final DirectorRepository directorRepository;
		
		@Inject
		public DirectorServiceImpl(final DirectorRepository directorRepository) {
			this.directorRepository = directorRepository;
		}
		
		@Override
		public Optional<Director> findDirectorById(final DirectorPK directorPK) {
			return directorRepository.findById(directorPK);
		}
		
		@Override
		public void persistNewDirector(final Director director) {
			directorRepository.save(director);
		}


}
