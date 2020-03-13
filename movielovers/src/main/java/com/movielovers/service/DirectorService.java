package com.movielovers.service;

import com.movielovers.model.Director;

public interface DirectorService {

	//Optional<Director> findDirectorById(DirectorPK directorPK);

	void persistNewDirector(Director director);

}
