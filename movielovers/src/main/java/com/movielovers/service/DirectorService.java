package com.movielovers.service;

import java.time.LocalDate;

import com.movielovers.model.Director;

public interface DirectorService {

	void persistNewDirector(Director director);

	Director findDirectorByNameAndBornDate(String name, LocalDate bornDate);

}
