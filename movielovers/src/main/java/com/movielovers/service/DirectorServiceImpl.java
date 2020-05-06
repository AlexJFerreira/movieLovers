package com.movielovers.service;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.inject.Named;

import com.movielovers.model.Director;
import com.movielovers.repository.DirectorRepository;

@Named("directorService")
public class DirectorServiceImpl implements DirectorService {
	
	private final DirectorRepository directorRepository;
		
		@Inject
		public DirectorServiceImpl(final DirectorRepository directorRepository) {
			this.directorRepository = directorRepository;
		}
		
		
		@Override
		public void persistNewDirector(final Director director) {
			directorRepository.save(director);
		}
		
		@Override
		public Director findDirectorByNameAndBornDate(final String name, final LocalDate bornDate) {
			return directorRepository.findDirectorByNameAndBornDate(name, bornDate);
		}


}
