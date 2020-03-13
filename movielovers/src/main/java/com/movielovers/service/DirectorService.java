package com.movielovers.service;

import java.util.Optional;

import com.movielovers.model.Director;
import com.movielovers.model.pk.DirectorPK;

public interface DirectorService {

	Optional<Director> findDirectorById(DirectorPK directorPK);

	void persistNewDirector(Director director);

}
